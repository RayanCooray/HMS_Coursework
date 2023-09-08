package bo.custom.impl;

import bo.custom.UserBo;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.UserDAO;
import dto.UserDTO;
import entity.user;

public class UserBOImpl implements UserBo {

    UserDAO userDAO =(UserDAO)DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOType.USER);

    @Override
    public boolean checkUser(String userName, String password) {
        return userDAO.check(userName,password);
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        return userDAO.save(new user(userDTO.getUserId(),userDTO.getUserName(),userDTO.getEmail(),userDTO.getPassword()));
    }


}
