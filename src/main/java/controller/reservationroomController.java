package controller;

import FactoryConfiguration.FactoryConfiguration;
import bo.BoFactory;
import bo.custom.RoomBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import dto.StudentDTO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tm.ReservationTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class reservationroomController implements Initializable {
    public JFXTextField Paying_AmountRes;
    public JFXTextField KeyMoney;
    public TableColumn  <?,?>  Paying_AmountTBL;
    public TableColumn <?,?>  Res_KeyAmount;
    public TableColumn <?,?>  RES_Room_Type;
    public TableColumn <?,?>  Res_Contact_Id;
    public TableColumn <?,?>  Res_ID;
    public TableColumn <?,?>  Stu_Id;
    public TableColumn <?,?>  Res_id;
    public JFXTextField Resservation_Id;

    public JFXTextField Contact_No;

    public JFXComboBox RoomTypeReservation;
    public TableView <ReservationTm> Tablereservation;
    public DatePicker Res_date;
    public JFXComboBox StudentComboBoox;

    StudentBO studentBO = (StudentBO) BoFactory.getBoFactory().getBO(BoFactory.BoType.STUDENT);

    RoomBO roomBO = (RoomBO) BoFactory.getBoFactory().getBO(BoFactory.BoType.ROOM);

    public void AddReservation(ActionEvent actionEvent) {

    }

    public void RoomTypeComboboxOnAction(ActionEvent actionEvent) {
        setRoomID();

    }

    public void ResStudentComboBoxOnaction(ActionEvent actionEvent) {
        setStudentId();
    }

    private void setRoomID() {
        try {
            List<RoomDTO> roomDtoList = roomBO.getAllrooms();
            ObservableList<String> roomIdObservableList = FXCollections.observableArrayList();
            roomDtoList.forEach(roomDto -> roomIdObservableList.add(roomDto.getRoom_type_id()));
            RoomTypeReservation.setItems(roomIdObservableList);

        } catch (RuntimeException ignored) {
        }

    }

    //private void setRoomID() {
//    try {
//        List<RoomDTO> roomDtoList = roomBO.getAllrooms();
//        ObservableList<String> roomIdObservableList = FXCollections.observableArrayList();
//        String selectedRoomId = String.valueOf(RoomTypeReservation.getValue());
//        Optional<RoomDTO> selectedRoom = roomDtoList.stream()
//                .filter(roomDto -> roomDto.getRoom_type_id().equals(selectedRoomId))
//                .findFirst();
//        roomIdObservableList.add(selectedRoom.get().getRoom_type_id());
//        RoomTypeReservation.setItems(roomIdObservableList);
//
//        if (selectedRoom.isPresent()) {
//            roomIdObservableList.add(String.valueOf(selectedRoom.get().getKey_money()));
//            KeyMoney.setText(String.valueOf(selectedRoom.get().getKey_money()));
//        }
//    } catch (RuntimeException ignored) {
//    }
//}
    private void setStudentId() {
        List<StudentDTO> allStudents = studentBO.getAllStudent();
        try {
            ObservableList<String> studentIdObservableList = FXCollections.observableArrayList();
            allStudents.forEach(studentDto -> studentIdObservableList.add(studentDto.getStudent_id()));
            StudentComboBoox.setItems(studentIdObservableList);
        } catch (RuntimeException ignored) {
        }
        
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setStudentId();
        setRoomID();
    }

    private void getAll(){


    }
}
