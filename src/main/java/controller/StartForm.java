package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartForm {
    public ImageView imghostel;

    public void getstartedonAction(ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) imghostel.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Login.fxml"))));
        stage1.centerOnScreen();
        stage1.show();
    }

    public void GetStarted(MouseEvent mouseEvent) throws IOException {
        Stage stage1 = (Stage) imghostel.getScene().getWindow();
        stage1.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/Login.fxml"))));
        stage1.centerOnScreen();
        stage1.show();
    }
}
