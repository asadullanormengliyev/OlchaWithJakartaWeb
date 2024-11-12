package pdp.uz.olchawithjakartaweb.service;

import lombok.RequiredArgsConstructor;
import pdp.uz.olchawithjakartaweb.dao.UserDao;
import pdp.uz.olchawithjakartaweb.model.User;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public User createUser(String name, String username, String password) {
        List<User> userList = getUsers();
        userList.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .ifPresent((a) -> {
                    throw new RuntimeException(a.getUsername() + " is exists ");
                });
        return userDao.createUser(new User(name, username, password));
    }

    public List<User> getUsers() {
        return userDao.listUser();
    }

    public Optional<User> checkUser(String username, String password) {
        Optional<User> user = userDao.checkUser(username, password);
        if (user.isPresent()) {
            return user;
        }
        return Optional.empty();
    }

}

