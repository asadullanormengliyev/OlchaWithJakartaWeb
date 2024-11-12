package pdp.uz.olchawithjakartaweb.dao;

import pdp.uz.olchawithjakartaweb.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao extends DatabaseConnection {
    private static final String CREATE_USER = "select * from add_users(i_name := ?, i_username := ?, i_password := ?)";
    private static final String GET_USER_BY_ID = "select * from \"user\" where id = ?";
    private static final String GET_USER_LIST = "select * from \"user\"";
    private static final String CHECK_USER_QUERY = "SELECT * FROM \"user\" WHERE username = ? and password = ?";


    public User createUser(User user) {
        try (Connection connection = connection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE_USER)) {
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.setString(2, user.getUsername());
            preparedStatement1.setString(3, user.getPassword());
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            return new User(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }
    public List<User> listUser() {
        try(Connection connection = connection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_LIST)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User(resultSet);
                userList.add(user);
            }
            return userList;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }

    public Optional<User> checkUser(String username, String password) {
        try (Connection connection = connection();
             PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_QUERY)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new User(resultSet));
            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database error while checking user", e);
        }
    }

    public User getUserById(int id) {
        try (Connection connection = connection();
             PreparedStatement preparedStatement1 = connection.prepareStatement(GET_USER_BY_ID)) {
            preparedStatement1.setInt(1, id);
            ResultSet resultSet = preparedStatement1.executeQuery();
            resultSet.next();
            return new User(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection is lost");
        }
    }

}
