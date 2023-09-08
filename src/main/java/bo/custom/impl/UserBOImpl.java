package bo.custom.impl;

import bo.custom.UserBo;
import dao.DAOFactory;
import dao.custom.StudentDAO;
import dao.custom.UserDAO;
import dto.StudentDTO;
import dto.UserDTO;
import entity.Student;
import entity.user;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean updateuser(UserDTO userDTO) {
        return userDAO.update(new user(userDTO.getUserId(),userDTO.getUserName(),userDTO.getEmail(),userDTO.getPassword()));
    }

    @Override
    public List<UserDTO> getAllusers() {
        List<UserDTO> customerDTOArrayList = new ArrayList<>();
        List<user> customerArrayList = userDAO.getAll();
        for (user user :customerArrayList) {
            customerDTOArrayList.add(new UserDTO(user.getUserName(),user.getUserId(),user.getEmail(),user.getPassword()));
        }
        return customerDTOArrayList;
    }

    @Override
    public boolean deleteStudent(String userId) {
        user user1 = new user();
        user1.setUserId(userId);
        return userDAO.delete(user1);
    }


}
