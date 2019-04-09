package api;

import exception.MyCheckedException;
import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao {

    void saveUser(User user) throws IOException;
    void saveUsers(List<User> users) throws MyCheckedException, FileNotFoundException;
    void removeUserById(Integer userId) throws IOException;
    void removeUserByLogin(String login) throws IOException;

    List<User> getAllUsers() throws FileNotFoundException, IOException;
    User getUserById(Integer userId) throws IOException;
    User getUserByLogin(String login) throws IOException;
}
