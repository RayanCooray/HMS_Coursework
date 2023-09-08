package dao.custom.impl;

import FactoryConfiguration.FactoryConfiguration;
import dao.custom.RoomDAO;
import entity.Room;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room entity) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Room entity) {
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
    public Room search(String id) {
        return null;
    }

    @Override
    public List<Room> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> roomList = session.createNativeQuery("SELECT * FROM room").addEntity(Room.class).list();

        transaction.commit();
        session.close();
        return roomList;
    }

    @Override
    public boolean delete(Room room) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.remove(room);
        transaction.commit();
        session.close();

        return true;
    }
}
