package application.TableViews;

import application.DatabaseUtils.TeacherCourseDAO;
import application.DatabaseUtils.TeacherDAO;
import application.TimetableClasses.Teacher;
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

/**
 * Created by dell on 11/11/2017.
 */
public class TeacherTableViewController implements Initializable {
    @FXML
    private TableColumn<Teacher, String> TeacherNameColumn;

    @FXML
    private AnchorPane TeacherViewAnchorPane;

    @FXML
    private TableView<Teacher> TeacherTableView;

    @FXML
    private TableColumn<Teacher,String> TeacherColumn;

    @FXML
    private TableColumn<Teacher,String> TeacherDepartmentColumn;

    ObservableList<Teacher> list = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TeacherDAO teacherDAO=new TeacherDAO();
        ArrayList<Teacher> teacherList = (ArrayList<Teacher>) teacherDAO.getAllTeachers();
        list = FXCollections.observableArrayList(teacherList);
        TeacherNameColumn.setCellValueFactory(new PropertyValueFactory<Teacher,String>("teacherName"));
        TeacherDepartmentColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("department"));
        TeacherColumn.setCellValueFactory(new PropertyValueFactory<Teacher, String>("id"));
        TeacherTableView.setItems(list);
    }

    public void refreshTable()
    {
        TeacherDAO teacherDAO=new TeacherDAO();
        ArrayList<Teacher> teacherList = (ArrayList<Teacher>) teacherDAO.getAllTeachers();
        list = FXCollections.observableArrayList(teacherList);
        TeacherTableView.setItems(list);
    }

}
