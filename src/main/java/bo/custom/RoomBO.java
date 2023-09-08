package bo.custom;

import bo.SuperBO;
import dto.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {

    boolean saveroom(RoomDTO roomDTO);

    List<RoomDTO> getAllrooms();

    boolean updateroom(RoomDTO roomDTO);


    boolean deleteroom(String roomTypeId);
}
