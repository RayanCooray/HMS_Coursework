package dao.custom;

import dao.CrudDAO;
import entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room> {
    List<Room> getAll();

    boolean delete(Room room);
}
