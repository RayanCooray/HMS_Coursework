package dao;


import dao.custom.impl.RoomDAOImpl;
import dao.custom.impl.StudentDAOImpl;
import dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        USER, STUDENT,ROOM
    }
    public SuperDAO getDAO(DAOType type){
        switch (type){
            case STUDENT:
                return new StudentDAOImpl();
            case USER:
                return new UserDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            default:
                return null;
        }
    }
}
