package bo;


import bo.custom.impl.RoomBOImpl;
import bo.custom.impl.StudentBOImpl;
import bo.custom.impl.UserBOImpl;


public class BoFactory {
    private static BoFactory boFactory;

    public BoFactory() {
    }

    public static BoFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BoFactory() : boFactory;
    }
    public enum BoType{
        USER, STUDENT,ROOM
    }
    public SuperBO getBO(BoType type){
        switch (type){
            case USER:
               return new UserBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            default:
                return null;
        }
    }
}
