package dao.custom.impl;

import dao.custom.ReservationDAO;
import entity.Reservation;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation entity) {
        return false;
    }

    @Override
    public boolean update(Reservation entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Reservation search(String id) {
        return null;
    }
}
