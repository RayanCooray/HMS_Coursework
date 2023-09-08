package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import bo.custom.UserBo;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import dto.UserDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.StudentTM;
import tm.UserTM;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class credentialscontroller implements Initializable {
    public TableView <UserTM> UserTable;
    public TableColumn <?,?> UserNameTBL;
    public TableColumn <?,?> UserIDTBL;
    public TableColumn <?,?> UserEmailTBL;
    public TableColumn <?,?> UserPasswordTBL;
    public JFXTextField UserNameTxt;
    public JFXTextField UserIDTxt;
    public JFXTextField UserEmailTxt;
    public JFXPasswordField  UserPasswordTxT;


    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBO(BoFactory.BoType.USER);

    public void adduserOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(UserNameTxt.getText());
        userDTO.setUserId(UserIDTxt.getText());
        userDTO.setEmail(UserEmailTxt.getText());
        userDTO.setPassword(UserPasswordTxT.getText());

        boolean isSaved = userBo.saveUser(userDTO);
        getAll();
        setCellValueFactory();
        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Registeration Successful!...").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"User not Add!...").show();
        }
    }

    public void UpdateUserOnAction(ActionEvent actionEvent) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(UserNameTxt.getText());
        userDTO.setUserId(UserIDTxt.getText());
        userDTO.setEmail(UserEmailTxt.getText());
        userDTO.setPassword(UserPasswordTxT.getText());

        boolean isupdated = userBo.updateuser(userDTO);
        if (isupdated){
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successful!...").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"Update was not Successful!...").show();
        }
    }

    public void DeleteUserOnAction(ActionEvent actionEvent) {
        UserTM selectedItem = UserTable.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            boolean isDeleted = userBo.deleteStudent(selectedItem.getUserId());
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "User deleted!...").show();
                getAll();
                setCellValueFactory();
            } else {
                new Alert(Alert.AlertType.ERROR, "User was not deleted   !...").show();
            }
        }
    }

    private void setCellValueFactory() {
        UserNameTBL.setCellValueFactory(new PropertyValueFactory<>("userName"));
        UserIDTBL.setCellValueFactory(new PropertyValueFactory<>("userId"));
        UserEmailTBL.setCellValueFactory(new PropertyValueFactory<>("email"));
        UserPasswordTBL.setCellValueFactory(new PropertyValueFactory<>("password"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getAll();
        setCellValueFactory();
    }

    private void getAll() {
        ObservableList<UserTM> observableList = FXCollections.observableArrayList();
        List<UserDTO> customerDTOList = userBo.getAllusers();
        for (UserDTO userDTO : customerDTOList) {
            observableList.add(new UserTM(
                    userDTO.getUserName(),
                    userDTO.getUserId(),
                    userDTO.getEmail(),
                    userDTO.getPassword()

                    )
            );
        }
        UserTable.setItems(observableList);
    }

    public void rowOnMouseClicked(MouseEvent mouseEvent) {
        Integer index = UserTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        UserNameTxt.setText(UserNameTBL.getCellData(index).toString());
        UserIDTxt.setText(UserIDTBL.getCellData(index).toString());
        UserEmailTxt.setText(UserEmailTBL.getCellData(index).toString());
        UserPasswordTxT.setText(UserPasswordTBL.getCellData(index).toString());
    }
}
