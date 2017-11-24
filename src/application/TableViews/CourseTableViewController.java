package application.TableViews;

import application.DatabaseUtils.CourseDAO;
import application.TimetableClasses.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseTableViewController implements Initializable {

    @FXML
    private AnchorPane CourseTableAnchorPane;

    @FXML
    private TableView<Course> CourseTable;

    @FXML
    private TableColumn<Course, String> CourseTableCreditColumn;

    @FXML
    private TableColumn<Course, String> CourseTableIDColumn;

    @FXML
    private TableColumn<Course, String> CourseTableNameColumn;

    @FXML
    private TableColumn<Course, String> CourseTableFrequencyColumn;

    ObservableList<Course> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Course> courseList = (ArrayList<Course>) CourseDAO.getAllCourses();
        list = FXCollections.observableArrayList(courseList);
        CourseTableNameColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        CourseTableCreditColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseCredits"));
        CourseTableFrequencyColumn.setCellValueFactory(new PropertyValueFactory<Course,String>("frequencyOfCourse"));
        CourseTableIDColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("courseId"));
        CourseTable.setItems(list);
    }

    public void refreshTable()
    {
        ArrayList<Course> courseList = (ArrayList<Course>) CourseDAO.getAllCourses();
        list = FXCollections.observableArrayList(courseList);
        CourseTable.setItems(list);
    }

}
