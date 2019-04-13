package api;
import exception.MyUncheckedException;
import model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    boolean addUser(User user) throws MyUncheckedException,IOException;

    void removeUserById(Integer userId) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserById(Integer userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean isCorrectLoginAndPassword(String login, String password);
}
