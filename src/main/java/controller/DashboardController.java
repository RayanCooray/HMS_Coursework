package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {
    public AnchorPane pane;
    public AnchorPane root;
    public ImageView img1;

    public void manageroomonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/ManageStudent.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    public void dshBackOnAction(ActionEvent actionEvent) throws IOException {

    }

    public void Dashboard(MouseEvent mouseEvent) throws IOException {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(load));
        stage1.centerOnScreen();
        stage1.show();
    }

    public void roommanageonaction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/managerooms.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    public void reservationOnAction(ActionEvent actionEvent)  {
        AnchorPane anchorPane = null;
        try {
            anchorPane = FXMLLoader.load(getClass().getResource("/view/reserverooms.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.getChildren().clear();
        root.getChildren().add(anchorPane);


    }

    public void CredentialsOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/credentials.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }


    public void Transactions(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/TranscationBalancer.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }
}
