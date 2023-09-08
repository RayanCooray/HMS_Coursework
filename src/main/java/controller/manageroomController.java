package controller;

import bo.BoFactory;
import bo.custom.RoomBO;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.RoomDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tm.RoomTM;
import tm.StudentTM;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class manageroomController implements Initializable {


    public TableView  ManageRoomTable;
    public TableColumn <?,?> RoomIDtable;
    public TableColumn <?,?> Room_Type;
    public TableColumn <?,?> RoomKeyMoney;
    public TableColumn <?,?> Qty;

    public JFXTextField RoomID;
    public JFXTextField RoomQTY;
    public JFXTextField RoomKeyMoneyad;
    public RadioButton Ac;
    public RadioButton NonAc;


    RoomBO roomBO = (RoomBO) BoFactory.getBoFactory().getBO(BoFactory.BoType.ROOM);

    public void Addroom(ActionEvent actionEvent) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setRoom_type_id(RoomID.getText());
        roomDTO.setQty(Qty.getText());
        roomDTO.setType(Ac.isSelected() ? "AC"  : "Non-Ac");
        roomDTO.setKey_money(Double.valueOf(RoomKeyMoneyad.getText()));

        boolean isSaved = roomBO.saveroom(roomDTO);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Room saved!...").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Room not saved!...").show();
        }

    }

    public void UpdateRoom(ActionEvent actionEvent) {
    }

    public void DeleteRoom(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
    }

    private void getAll() {
//        ObservableList<RoomTM> observableList = FXCollections.observableArrayList();
//        List<RoomDTO> roomDTOList = roomBO.getAllrooms();
//        for (RoomDTO roomDTO : roomDTOList) {
//            observableList.add(new RoomTM(
//                            roomDTO.getRoom_type_id(),
//                            roomDTO.getType(),
//                            roomDTO.getKey_money(),
//                            roomDTO.getQty()
//                    )
//            );
//        }
//        ManageRoomTable.setItems(observableList);
    }

//    private void setCellValueFactory() {
//        RoomIDtable.setCellValueFactory(new PropertyValueFactory<>("student_id"));
//        StudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        StudentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        StudentContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
//        StudentDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
//        StudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
//    }



}
