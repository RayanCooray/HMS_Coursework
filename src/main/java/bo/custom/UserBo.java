package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

import java.util.List;

public interface UserBo extends SuperBO {

        boolean checkUser(String userName, String password);
        boolean saveUser(UserDTO userDTO);


        boolean updateuser(UserDTO userDTO);

        List<UserDTO> getAllusers();

        boolean deleteStudent(String userId);
}