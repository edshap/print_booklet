package org.print.model.dao.impl;

import org.print.model.dao.UserDao;
import org.print.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Alina on 17.02.2018.
 */
public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) throws SQLException {
        if (noEntryInDB(user)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (login, password, role)" +
                    "VALUES (?, ?, ?)")) {
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getRole().toString());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }

    @Override
    public boolean noEntryInDB(User user) {
        try {
        if(user.getLogin().equals((findByLogin(user.getLogin())).getLogin())){
            return false;
        }
        } catch (Exception e){
            return false;
        }
/*        try {
            return (Objects.isNull(findByLogin(user.getLogin())));
        } catch (SQLException e){
            return true;
        }*/

        return true;
    }

    @Override
    public User findByLogin(String login) throws SQLException {
        User user;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM printbooklet.user WHERE login = ?");
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            user = new User();
            while (resultSet.next()) {
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setRole(User.ROLES.valueOf(resultSet.getString(4)));
            }
        } catch(SQLException e){
                throw new SQLException();
            }
        return user;
    }

    @Override
    public User findById(int id) {
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM user WHERE id =" + id )){
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                int idUser = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                String role = resultSet.getString(4);
                if (idUser==id){
                    user.setId(id);
                    user.setLogin(login);
                    user.setPassword(password);
                    user.setRole(User.ROLES.valueOf(role));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user")) {
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                String role = resultSet.getString(4);
                User user = new User();
                user.setId(id);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(User.ROLES.valueOf(role));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void update(User entity) throws SQLException{
        int id = entity.getId();
        String loginNew = entity.getLogin();
        String passwordNew = entity.getPassword();
        String roleNew = entity.getRole().toString();
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user " +
                "SET login = ?, password = ?, role = ? WHERE id = " + id )) {
            preparedStatement.setString(1, loginNew);
            preparedStatement.setString(2, passwordNew);
            preparedStatement.setString(3, roleNew);
            preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void delete(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM user WHERE id =" + id )){
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
