package service;

import api.UserDao;
import api.UserService;
import dao.UserDaoImpl;
import exception.MyUncheckedException;
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

    @Override
    public User getUserById(Integer userId) throws IOException {
        List<User> users = getAllUsers();

        for (User user : users
        ) {
            boolean isFoundUser = user.getId().equals(userId);
            if (isFoundUser) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {

        try {
            List<User> users = getAllUsers();
            for (User user : users) {
                boolean isFounder = user.getLogin().equals(login);
                if (isFounder) {
                    return user;
                }
            }
        }catch (IOException e){
            e.getStackTrace();

        }
        return null;
    }

    @Override
    public boolean isCorrectLoginAndPassword(String login, String password)   {
        User foundUser = getUserByLogin(login);

        if (foundUser == null) {
            return false;
        }

        boolean isCorrectLogin = foundUser.getLogin().equals(login);
        boolean isCorrectPass = foundUser.getPassword().equals(password);

        return isCorrectLogin && isCorrectPass;
    }
    private boolean isLoginAlreadyExist(String login) throws IOException {
        User user = getUserByLogin(login);

        return user != null;
    }

    public boolean addUser(User user) throws MyUncheckedException{
        try {
            if (isLoginAlreadyExist(user.getLogin())) {
                throw new MyUncheckedException(" Login already exist !!!! ");
            }
            if (userValidator.isValidate(user)) {
                userDao.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void removeUserById(Integer userId) throws IOException {
        userDao.removeUserById(userId);
    }

}
