package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import model.User;
import valid.UserValidator;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {


    private static UserServiceImpl instance = null;
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public void addUser(User user) throws IOException{
        if (userValidator.isValidate(user)) {
            userDao.saveUser(user);
        }
    }

    public void removeUserById(Integer userId) throws IOException {
        userDao.removeUserById(userId);
    }

}
