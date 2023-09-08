package dao.custom;

import dao.CrudDAO;
import entity.user;

import java.util.List;

public interface UserDAO extends CrudDAO<user> {

    boolean check(String userName, String password);

    List<user> getAll();

    boolean delete(user user1);
}
