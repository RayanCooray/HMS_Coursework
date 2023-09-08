package bo.custom.impl;

import bo.SuperBO;
import bo.custom.RoomBO;
import dao.DAOFactory;
import dao.custom.RoomDAO;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Room;
import entity.Student;

import java.util.ArrayList;
import java.util.List;


public class RoomBOImpl implements RoomBO{

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.ROOM);


    @Override
    public boolean saveroom(RoomDTO roomDTO) {
        return roomDAO.save(new Room(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(),roomDTO.getQty()));
    }

    @Override
    public List<RoomDTO> getAllrooms() {
        List<RoomDTO> customerDTOArrayList = new ArrayList<>();
        List<Room> customerArrayList = roomDAO.getAll();
        for (Room room:customerArrayList) {
            customerDTOArrayList.add(new RoomDTO(room.getRoom_type_id(),room.getType(),room.getKey_money(),room.getQty()));
        }
        return customerDTOArrayList;
    }

    @Override
    public boolean updateroom(RoomDTO roomDTO) {
        return roomDAO.update(new Room(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(),roomDTO.getQty()));
    }

    @Override
    public boolean deleteroom(String roomTypeId) {
        Room room = new Room();
        room.setRoom_type_id(roomTypeId);
        return roomDAO.delete(room);
    }


}
