package pdp.uz.dao;

import pdp.uz.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends DatabaseConnection{
    private static final String GET_USER_LIST = "select * from users";
    private static final String GET_USER_BY_ID = "select * from users where id = ?";
    private static final String CREATE_USER = "insert into users(name, username, password) values (?,?,?) returning id";
    private static final String DELETE_USER = "select delete_users(?)";

    public List<User> userList(){
        List<User> userList = new ArrayList<>();
        try(Connection connection = connection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_LIST);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    public User addUser(User user) {
        try(Connection connection = connection()){
            PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE_USER);
            PreparedStatement preparedStatement2 = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.setString(2, user.getUsername());
            preparedStatement1.setString(3, user.getPassword());
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            int id = resultSet.getInt("id");
            preparedStatement2.setInt(1, id);
            ResultSet resultSet1 = preparedStatement2.executeQuery();
            resultSet1.next();
            return new User(resultSet1);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }

    public void deleteUser(int id){
        try(Connection connection = connection()){
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
