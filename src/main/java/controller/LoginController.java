package controller;

import bo.BoFactory;
import bo.custom.UserBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    public JFXTextField UserNameTXT;
    public ImageView quesImg;
    public JFXPasswordField PasswordText;
    public AnchorPane hidePassword;
    public JFXButton loginBTNid;
    UserBo userBO = (UserBo) BoFactory.getBoFactory().getBO(BoFactory.BoType.USER);
    public void signuponAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) quesImg.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/SignUp.fxml"))));
        stage1.centerOnScreen();
        stage1.show();

    }

    public void LoginonAction(ActionEvent actionEvent) throws IOException {
//        Stage stage2 = (Stage) quesImg.getScene().getWindow();
//        stage2.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml"))));
//        stage2.centerOnScreen();
//        stage2.show();

        String username = UserNameTXT.getText();
        String password = PasswordText.getText();


        boolean isValid = userBO.checkUser(username,password);
        if (isValid){
            Stage stage2 = (Stage) quesImg.getScene().getWindow();
            stage2.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml"))));
            stage2.centerOnScreen();
            stage2.show();

        }else{
            new Alert(Alert.AlertType.ERROR, "Username and Password incorrect!...").show();
        }
    }


    public void hidePasswordOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void UserNameOnAction(ActionEvent actionEvent) {PasswordText.requestFocus();}

    public void PWonAction(ActionEvent actionEvent) {loginBTNid.fire();}

}
