package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;


import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDaoJDBCImpl userService = new UserDaoJDBCImpl();
    private final UserDaoHibernateImpl userServiceHibernate = new UserDaoHibernateImpl();


    @Override
    public void createUsersTable() {
        userServiceHibernate.createUsersTable();
    }

    @Override
    public void dropUsersTable() {
        userServiceHibernate.dropUsersTable();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        userServiceHibernate.saveUser(name, lastName, age);
    }

    @Override
    public void removeUserById(long id) {
        userServiceHibernate.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userServiceHibernate.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userServiceHibernate.cleanUsersTable();
    }
}
