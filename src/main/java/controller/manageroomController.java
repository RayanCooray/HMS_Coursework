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
import javafx.scene.input.MouseEvent;
import tm.RoomTM;
import tm.StudentTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class manageroomController implements Initializable {


    public TableView <RoomTM> ManageRoomTable;
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
        roomDTO.setQty(RoomQTY.getText());
        roomDTO.setType(Ac.isSelected() ? "AC"  : "Non-Ac");
        roomDTO.setKey_money(Double.valueOf(RoomKeyMoneyad.getText()));

        boolean isSaved = roomBO.saveroom(roomDTO);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Room saved!...").show();
            getAll();
            setCellValueFactory();

        }else {
            new Alert(Alert.AlertType.ERROR, "Room not saved!...").show();
        }
        setCellValueFactory();

    }

    public void UpdateRoom(ActionEvent actionEvent) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoom_type_id(RoomID.getText());
        roomDTO.setQty(Qty.getText());
        roomDTO.setType(Ac.isSelected() ? "Ac" : "Non-Ac");
        roomDTO.setKey_money(Double.valueOf(RoomKeyMoneyad.getText()));

        boolean isUpdated = roomBO.updateroom(roomDTO);
//
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully!!").show();

        }else {
            new Alert(Alert.AlertType.ERROR, "Error!!").show();
        }

    }

    public void DeleteRoom(ActionEvent actionEvent) {
        RoomTM selectedItem = ManageRoomTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            boolean isDeleted = roomBO.deleteroom(selectedItem.getRoom_type_id());
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Room deleted!...").show();
                getAll();
                setCellValueFactory();
            } else {
                new Alert(Alert.AlertType.ERROR, "Room was not deleted   !...").show();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        getAll();
    }

    private void getAll() {
        ObservableList<RoomTM> observableList = FXCollections.observableArrayList();
        List<RoomDTO> roomDTOList = roomBO.getAllrooms();
        for (RoomDTO roomDTO : roomDTOList) {
            observableList.add(new RoomTM(
                            roomDTO.getRoom_type_id(),
                            roomDTO.getType(),
                            roomDTO.getKey_money(),
                            roomDTO.getQty()
                    )
            );
        }
        ManageRoomTable.setItems(observableList);
    }

    private void setCellValueFactory() {
        RoomIDtable.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        Room_Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        RoomKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        Qty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }


    public void RoomtablerowOnMouseClicked(MouseEvent mouseEvent) {
        Integer index = ManageRoomTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        RoomID.setText(RoomIDtable.getCellData(index).toString());
        Ac.setText(Room_Type.getCellData(index).toString());
        RoomQTY.setText(Qty.getCellData(index).toString());
        RoomKeyMoneyad.setText(RoomKeyMoney.getCellData(index).toString());

    }
}
