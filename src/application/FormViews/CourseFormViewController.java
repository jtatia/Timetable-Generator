package application.FormViews;

import application.DatabaseUtils.CourseBatchDAO;
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
    private TextField CourseDeleteTextField;

    @FXML
    private void submitButtonAction(ActionEvent event) throws IOException {
        String courseId = CourseIdTextField.getText();
        String courseName = CourseNameTextField.getText();
            int courseCredits = Integer.parseInt(CourseCreditsTextField.getText());
            int frequencyOfCourse = Integer.parseInt(CourseFrequencyTextField.getText());
            String teacherId = TeacherIdTextView.getText();
            CourseCreditsTextField.setText("");
            CourseFrequencyTextField.setText("");
            CourseIdTextField.setText("");
            CourseNameTextField.setText("");
            TeacherIdTextView.setText("");
            Course course = new Course(courseId, courseName, frequencyOfCourse, courseCredits);
            CourseDAO.insertCourse(course);
            TeacherCourseDAO.insertCourseTeacherRecord(courseId, teacherId);
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        String courseId = CourseDeleteTextField.getText();
        CourseDeleteTextField.setText("");
        CourseBatchDAO.deleteCourseBatchRecord(courseId);
        TeacherCourseDAO.deleteCourseTeacherRecord(courseId);
        CourseDAO.deleteCourse(courseId);
    }


}
