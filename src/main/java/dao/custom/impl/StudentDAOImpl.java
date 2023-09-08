package dao.custom.impl;

import FactoryConfiguration.FactoryConfiguration;
import dao.custom.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }


    @Override
    public boolean delete(Student entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.remove(entity);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public Student search(String id) {
        return null;
    }



    @Override
    public List<Student> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> studentArrayList = session.createNativeQuery("SELECT * FROM student").addEntity(Student.class).list();

        transaction.commit();
        session.close();
        return studentArrayList;
    }
}
