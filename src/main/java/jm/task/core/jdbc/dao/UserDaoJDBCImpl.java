package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {
        Connection connection = null;
        try (Connection con = Util.getConnection()) {
            con.setAutoCommit(false);
            String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), lastName VARCHAR(100), age INT)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            con.commit();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dropUsersTable() {
        Connection connection = null;
        try (Connection con = Util.getConnection()){
            String sql = "DROP TABLE IF EXISTS users";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        try (Connection con = Util.getConnection()) {
            String sql = "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setInt(3, age);
            statement.executeUpdate();
            System.out.println("User с именем " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeUserById(long id) {
        Connection connection = null;
        try (Connection con = Util.getConnection()) {
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setBigDecimal(1, BigDecimal.valueOf(id));
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection = null;
        List <User> users = new ArrayList<>();
        try (Connection con = Util.getConnection()){
            String sql = "SELECT * FROM users";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                long id = (long) rs.getInt("id");
                String name = rs.getString("name");
                String lastName = rs.getString("lastname");
                byte age = (byte) rs.getInt("age");
                users.add(new User(id, name, lastName, age));
            }

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Connection connection = null;
        try (Connection con = Util.getConnection()){
            String sql = "TRUNCATE TABLE users";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
}
