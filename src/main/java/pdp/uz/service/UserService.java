package pdp.uz.service;

import pdp.uz.dao.UserDao;
import pdp.uz.model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;
    public UserService(UserDao userDao){
        this.userDao = new UserDao();
    }

    public User addUser(String name, String username, String password){
        if (hasUser(username)){
            throw new RuntimeException(username + "is exists");
        }
        return userDao.addUser(new User(name, username, password));
    }

    private boolean hasUser(String username){
        List<User> users = userDao.userList();
        for (User user:users){
            if (user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public List<User> userList(){
        return userDao.userList();
    }

    public void deleteUser(int id){
        userDao.deleteUser(id);
    }

    public User getUserById(int userId){
        List<User> users = userDao.userList();
        for (User user:users){
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }
}
