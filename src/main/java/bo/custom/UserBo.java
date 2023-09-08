package bo.custom;

import bo.SuperBO;
import dto.UserDTO;

public interface UserBo extends SuperBO {

        boolean checkUser(String userName, String password);
        boolean saveUser(UserDTO userDTO);


}