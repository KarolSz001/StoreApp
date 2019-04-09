package valid;

import exception.MyUncheckedException;
import model.User;

public class UserValidator {
    private final int MIN_LENGHT_PASS = 5;
    private final int MIN_LENGHT_LOGIN = 3;

    private static UserValidator instance  = null;

    public UserValidator() {
    }

    public static UserValidator getInstance(){
        if(instance == null){
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws MyUncheckedException {
        if(isPassowrdLenghtTooShort(user.getPassword())){
            throw new MyUncheckedException(" Password is too short");
        }
        if(isLoginLenghtTooShort(user.getLogin())){
            throw new MyUncheckedException(" Login is too short ");
        }
        return true;
    }

    private boolean isPassowrdLenghtTooShort(String pass){
        return pass.length() < MIN_LENGHT_PASS;
    }

    private boolean isLoginLenghtTooShort(String pass){
        return pass.length() < MIN_LENGHT_PASS;
    }
}
