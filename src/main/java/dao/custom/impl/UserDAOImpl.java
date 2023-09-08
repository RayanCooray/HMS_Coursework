package dao.custom.impl;

import FactoryConfiguration.FactoryConfiguration;
import dao.custom.UserDAO;
import entity.user;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(user entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean update(user entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public user search(String id) {
        return null;
    }

    @Override
    public boolean check(String userName, String password) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<user> userList = session.createNativeQuery("SELECT * FROM user WHERE userName = ?", user.class)
                .setParameter(1,userName)
                .getResultList();
        for (user user1:userList) {
            transaction.commit();
            session.close();
            if (user1.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
