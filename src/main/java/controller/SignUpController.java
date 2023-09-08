package controller;

import bo.BoFactory;
import bo.custom.UserBo;
import com.jfoenix.controls.JFXTextField;
import dto.UserDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {
    public ImageView quesImg;
    public JFXTextField signupUserName;
    public JFXTextField UserID;
    public JFXTextField UserEmail;

    public JFXTextField PasswordUser;

    UserBo userBO = (UserBo) BoFactory.getBoFactory().getBO(BoFactory.BoType.USER);

    public void signuptoD24onAction(ActionEvent actionEvent) {
        String id = UserID.getText();
        String name = signupUserName.getText();
        String email = UserEmail.getText();
        String passworduser = PasswordUser.getText();

        UserDTO userDTO = new UserDTO(id,name,email,passworduser);
        boolean isSaved = userBO.saveUser(userDTO);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Registeration Successful!...").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"User not Add!...").show();
        }


    }

    public void backOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) quesImg.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Login.fxml"))));
        stage1.centerOnScreen();
        stage1.show();
    }
}
