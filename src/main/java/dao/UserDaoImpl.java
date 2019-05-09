package dao;

import api.UserDao;
import exception.MyUncheckedException;
import model.User;
import model.parser.UserParser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String fileName = "users.data";
    private static UserDaoImpl instance = null;


    private UserDaoImpl() {
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            System.out.println("Error with file path");
            System.exit(-1);
        }
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }

        return instance;
    }

    @Override
    public void saveUser(User user) throws MyUncheckedException, IOException {
        List<User> users = getAllUsers();
        users.add(user);
        saveUsers(users);
    }

    @Override
    public void saveUsers(List<User> users) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User user : users) {
            printWriter.println(user.toString());
        }
        printWriter.close();
    }

    @Override
    public void removeUserById(Integer userId) throws IOException {
        List<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            boolean isFounder = users.get(i).getId().equals(userId);
            if (isFounder) {
                users.remove(i);
            }
        }
        saveUsers(users);
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for (int i = 0; i < users.size(); i++) {
            boolean isFoundUser = users.get(i).getLogin().equals(login);
            if (isFoundUser) {
                users.remove(i);
            }
        }
        saveUsers(users);

    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            User user = UserParser.stringToUser(readLine);
            if (user != null) {
                users.add(user);
            }
        }
        return users;
    }

    @Override
    public User getUserByLogin(String login) throws IOException {
        return null;
    }


}



