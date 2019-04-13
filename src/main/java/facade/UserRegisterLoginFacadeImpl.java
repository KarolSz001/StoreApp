package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import exception.MyUncheckedException;
import model.User;
import service.UserServiceImpl;

import java.io.IOException;


public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {
    private UserService userService = UserServiceImpl.getInstance();
    private static UserRegisterLoginFacade instance = null;

    public UserRegisterLoginFacadeImpl() {
    }

    public static UserRegisterLoginFacade getInstance() {
        if (instance == null) {
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    @Override
    public String registerUser(User user) {
        try {
            userService.addUser(user);
            return " Register successfully ";
        } catch (IOException e) {
            throw new MyUncheckedException(" ADD USER ERROR ");
        }
    }

    @Override
    public boolean loginUser(String login, String password) {
        if (userService.isCorrectLoginAndPassword(login, password)) {
            return true;
        }

        return false;
    }
}
