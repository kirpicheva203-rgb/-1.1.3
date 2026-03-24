<<<<<<< HEAD
package jm.task.core.jdbc.dao;



import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), lastName VARCHAR(100), age INT)").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            User user = new User(name, lastName, age);
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()){
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
=======
package jm.task.core.jdbc.dao;



import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS users(id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(80), lastName VARCHAR(100), age INT)").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            User user = new User(name, lastName, age);
            transaction = session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = Util.getSessionFactory().openSession()){
            return session.createQuery("from User", User.class).list();
        }
    }

    @Override
    public void cleanUsersTable() {
        Transaction transaction = null;
        try (Session session = Util.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            session.getTransaction().commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
>>>>>>> 4d611f2 (Задача 1.1.4)
