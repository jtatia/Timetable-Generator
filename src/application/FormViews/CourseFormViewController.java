package application.FormViews;

import application.DatabaseUtils.CourseDAO;
import application.DatabaseUtils.TeacherCourseDAO;
import application.TimetableClasses.Course;
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
public class CourseFormViewController {
    @FXML
    private Label CourseInputFormLabel;

    @FXML
    private TextField TeacherIdTextView;

    @FXML
    private Button DeleteButtonTextField;

    @FXML
    private TextField CourseCreditsTextField;

    @FXML
    private TextField CourseIdTextField;

    @FXML
    private TextField CourseNameTextField;

    @FXML
    private TextField CourseFrequencyTextField;

    @FXML
    private Button CourseButtonSubmitForm;

    @FXML
    private AnchorPane CourseFormAnchorView;


    @FXML
    private void submitButtonAction(ActionEvent event) throws IOException {
        int courseCredits=Integer.parseInt(CourseCreditsTextField.getText());
        int frequencyOfCourse=Integer.parseInt(CourseFrequencyTextField.getText());
        String courseId=CourseIdTextField.getText();
        String courseName=CourseNameTextField.getText();
        String teacherId=TeacherIdTextView.getText();
        CourseCreditsTextField.setText("");
        CourseFrequencyTextField.setText("");
        CourseIdTextField.setText("");
        CourseNameTextField.setText("");
        TeacherIdTextView.setText("");
        TeacherCourseDAO.insertCourseTeacherRecord(courseId,teacherId);
        Course course = new Course(courseId,courseName,frequencyOfCourse,courseCredits);
        CourseDAO.insertCourse(course);
    }


}
