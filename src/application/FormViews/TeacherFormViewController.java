package application.FormViews;

import application.DatabaseUtils.TeacherDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;


/**
 * Created by dell on 11/11/2017.
 */
public class TeacherFormViewController {

    @FXML
    private TextField TeacherIdTextField;

    @FXML
    private TextField TeacherDepartmentTextField;

    @FXML
    private Button TeacherFormSubmitButton;

    @FXML
    private AnchorPane TeacherFormAnchorView;

    @FXML
    private TextField TeacherNameTextField;

    @FXML
    private Label TeacherFormHeading;

    @FXML
    private void submitButtonAction(ActionEvent event) throws IOException {
        String teacherId=TeacherIdTextField.getText();
        String teacherName=TeacherNameTextField.getText();
        String department=TeacherDepartmentTextField.getText();
        TeacherDAO teacherDAO=new TeacherDAO();
        teacherDAO.insertTeacher(teacherId,teacherName,department);
        TeacherDepartmentTextField.setText("");
        TeacherIdTextField.setText("");
        TeacherNameTextField.setText("");
    }

}
