package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
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
    public String registerUser(User user){
        try {
            userService.addUser(user);
            return " Register done ";
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    public boolean loginUser(String login, String password) {
        try {
            if (userService.isCorrectLoginAndPassword(login, password)) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
