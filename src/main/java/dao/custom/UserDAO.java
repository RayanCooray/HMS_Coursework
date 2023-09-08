package dao.custom;

import dao.CrudDAO;
import entity.user;

public interface UserDAO extends CrudDAO<user> {

    boolean check(String userName, String password);

}
