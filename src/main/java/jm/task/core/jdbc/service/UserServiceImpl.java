package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDaoJDBCImpl userService = new UserDaoJDBCImpl();
    private final UserDaoHibernateImpl userServiceHibernate = new UserDaoHibernateImpl();


    public void createUsersTable() {
        userServiceHibernate.createUsersTable();
    }
    public void dropUsersTable() {
        userServiceHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userServiceHibernate.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userServiceHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userServiceHibernate.getAllUsers();
    }

    public void cleanUsersTable() {
        userServiceHibernate.cleanUsersTable();
    }
}
