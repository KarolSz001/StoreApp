package dao;

import api.UserDao;
import exception.MyCheckedException;
import exception.MyUncheckedException;
import model.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDaoSqlImpl implements UserDao {

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "root";
    private final String password = "admin";
    private final User userDao = new User();

    public UserDaoSqlImpl() {
        init();
    }

    private void init() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName + "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveUser(User user) throws MyUncheckedException, IOException {
        PreparedStatement statement;
        try{
            String query = "insert into" + tableName + " (login,password) values(?,?)";
            statement = connection.prepareStatement(query);

            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());

            statement.execute();
            statement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void removeUserById(Integer userId) throws IOException {

        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where id = ?";
            statement = connection.prepareStatement(query);

            statement.setInt(1, userId);
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserByLogin(String login) throws IOException {
        PreparedStatement statement;
        try {
            String query = "delete from " + tableName + " where login = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, login);
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        List<User> users = new LinkedList<>();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String query = "select * from" + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String pass = resultSet.getString("password");

                User user = new User(id, login, pass);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(User user) {
        PreparedStatement statement;
        try{
            String query  = "update" + tableName + " set login = ?, password = ? where id=?";
            statement = connection.prepareStatement(query);

            statement.setString(1,user.getLogin());
            statement.setString(2,user.getPassword());
            statement.setInt(3,user.getId());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
