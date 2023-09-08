package controller;

import FactoryConfiguration.FactoryConfiguration;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class reservationroomController implements Initializable {
    public JFXTextField Paying_AmountRes;
    public JFXTextField KeyMoney;
    public TableColumn Paying_AmountTBL;
    public TableColumn Res_KeyAmount;
    public TableColumn RES_Room_Type;
    public TableColumn Res_Contact_Id;
    public TableColumn Res_ID;
    public TableColumn Stu_Id;
    public TableColumn Res_id;
    public JFXTextField Resservation_Id;

    public JFXTextField Contact_No;

    public JFXComboBox RoomTypeReservation;
    public TableView Tablereservation;
    public DatePicker Res_date;
    public JFXComboBox StudentComboBoox;

    public void AddReservation(ActionEvent actionEvent) {
    }

    public void RoomTypeComboboxOnAction(ActionEvent actionEvent) {
    }

    public void ResStudentComboBoxOnaction(ActionEvent actionEvent) {
        getAll();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
    }

    private void getAll(){

    }
}
