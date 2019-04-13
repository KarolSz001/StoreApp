package api;

import exception.MyCheckedException;
import exception.MyUncheckedException;
import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws MyUncheckedException, IOException;
    void saveUsers(List<User> users) throws MyCheckedException, FileNotFoundException;
    void removeUserById(Integer userId) throws IOException;
    void removeUserByLogin(String login) throws IOException;
    List<User> getAllUsers() throws IOException  ;
    User getUserByLogin() throws IOException;
}
