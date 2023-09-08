package controller;

import bo.BoFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import tm.StudentTM;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ManageStudentController implements Initializable {
    public JFXTextField StudentForm_Contact_No;
    public JFXTextField StudentForm_Name;
    public JFXTextField StudentForm_Address;
    public JFXTextField StudentFrom_Id;
    public DatePicker DatePicer;
    public RadioButton RadioButton_StuMale;
    public RadioButton RadioButtonStu_Female;
    public TableView   StudentTable;
    public TableColumn <?,?> StudentId;
    public TableColumn <?,?> StudentName;
    public TableColumn <?,?> StudentAddress;
    public TableColumn <?,?> StudentContactNo;
    public TableColumn <?,?> StudentGender;
    public TableColumn <?,?> StudentDOB;
    public JFXButton addStudentBTN;

    StudentBO studentBO = (StudentBO) BoFactory.getBoFactory().getBO(BoFactory.BoType.STUDENT);

    String ID;



    public void AddStudent_OnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudent_id(StudentFrom_Id.getText());
        studentDTO.setName(StudentForm_Name.getText());
        studentDTO.setAddress(StudentForm_Address.getText());
        studentDTO.setContact_no(StudentForm_Contact_No.getText());
        studentDTO.setDob(Date.valueOf(DatePicer.getValue()));
        studentDTO.setGender(RadioButton_StuMale.isSelected() ? "Male" : "Female");

        boolean isSaved = studentBO.saveStudent(studentDTO);

        if (isSaved){
            new Alert(Alert.AlertType.CONFIRMATION, "Student saved!...").show();
        }else {
            new Alert(Alert.AlertType.ERROR, "Student not saved!...").show();
        }
        getALl();
        clearTextFileds();
    }

    public void UpdateStu_OnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudent_id(StudentFrom_Id.getText());
        studentDTO.setName(StudentForm_Name.getText());
        studentDTO.setAddress(StudentForm_Address.getText());
        studentDTO.setContact_no(StudentForm_Contact_No.getText());
        studentDTO.setGender(RadioButton_StuMale.isSelected() ? "Male" : "Female");

        boolean isUpdated = studentBO.updateStudent(studentDTO);
//
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully!!").show();

        }else {
            new Alert(Alert.AlertType.ERROR, "Error!!").show();
        }
        setCellValueFactory();
        clearTextFileds();
    }

    public void deleteStudent_OnAction(ActionEvent actionEvent) {

    }

    private void setCellValueFactory() {
        StudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        StudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        StudentAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        StudentContactNo.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        StudentDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        StudentGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getALl();
        setCellValueFactory();
    }
    private void clearTextFileds() {
        StudentFrom_Id.clear();
        StudentForm_Name.clear();
        StudentForm_Address.clear();
        StudentForm_Contact_No.clear();
        DatePicer.setValue(null);

    }
    private void getALl() {
        ObservableList<StudentTM> observableList = FXCollections.observableArrayList();
        List<StudentDTO> customerDTOList = studentBO.getAllStudent();
        for (StudentDTO studentDTO : customerDTOList) {
            observableList.add(new StudentTM(
                            studentDTO.getStudent_id(),
                            studentDTO.getName(),
                            studentDTO.getAddress(),
                            studentDTO.getContact_no(),
                            studentDTO.getDob(),
                            studentDTO.getGender()
                    )
            );
        }
        StudentTable.setItems(observableList);
    }

    public void rowOnMouseClicked(MouseEvent mouseEvent) {
        Integer index = StudentTable.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }

        StudentFrom_Id.setText(StudentId.getCellData(index).toString());
        StudentForm_Name.setText(StudentName.getCellData(index).toString());
        StudentForm_Contact_No.setText(StudentContactNo.getCellData(index).toString());
        StudentForm_Address.setText(StudentAddress.getCellData(index).toString());
        DatePicer.setValue(LocalDate.parse(StudentDOB.getCellData(index).toString()));
        RadioButton_StuMale.setText(StudentGender.getCellData(index).toString());
    }

    public void StudentIDonAction(ActionEvent actionEvent) {StudentForm_Name.requestFocus();}
    public void StudnetNameOnAction(ActionEvent actionEvent) {DatePicer.requestFocus();}
    public void DatePickerOnAction(ActionEvent actionEvent) {StudentForm_Address.requestFocus();}
    public void StudnetAddressOnAction(ActionEvent actionEvent) {StudentForm_Contact_No.requestFocus();}
    public void StudentContactNoOnAction(ActionEvent actionEvent) {}
}
