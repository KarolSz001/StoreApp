package valid;

import api.UserDao;
import dao.UserDaoImpl;
import exception.MyUncheckedException;
import model.User;

import java.io.IOException;

public class UserValidator {
    private final int MIN_LENGHT_PASS = 5;
    private final int MIN_LENGHT_LOGIN = 3;

    private static UserValidator instance = null;
    private static UserDao userDao = UserDaoImpl.getInstance();

    public UserValidator() {
    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws MyUncheckedException {
        if (isPassowrdLenghtCorrect(user.getPassword())) {
            throw new MyUncheckedException(" Password is too short");
        }
        if (isLoginLenghtTooCorrect(user.getLogin())) {
            throw new MyUncheckedException(" Login is too short ");
        }
        return true;
    }



    private boolean isPassowrdLenghtCorrect(String pass) {
        return pass.length() < MIN_LENGHT_PASS;
    }

    private boolean isLoginLenghtTooCorrect(String login) {
        return login.length() < MIN_LENGHT_LOGIN;
    }



}
