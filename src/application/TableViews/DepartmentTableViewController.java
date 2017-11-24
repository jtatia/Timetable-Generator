package application.TableViews;

import application.DatabaseUtils.DepartmentDAO;
import application.TimetableClasses.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DepartmentTableViewController implements Initializable {

    @FXML
    private AnchorPane DepartmentTableAnchorPane;

    @FXML
    private TableColumn<Department, String> DepartmentNameColumn;

    @FXML
    private TableColumn<Department, String> DepartmentIDColumn;

    @FXML
    private TableView<Department> DepartmentTable;

    ObservableList<Department> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Department> deptList = (ArrayList<Department>) DepartmentDAO.getAllDepartments();
        list = FXCollections.observableArrayList(deptList);
        DepartmentNameColumn.setCellValueFactory(new PropertyValueFactory<Department,String>("deptName"));
        DepartmentIDColumn.setCellValueFactory(new PropertyValueFactory<Department, String>("id"));
        DepartmentTable.setItems(list);
    }

    public void refreshTable()
    {
        ArrayList<Department> courseList = (ArrayList<Department>) DepartmentDAO.getAllDepartments();
        list = FXCollections.observableArrayList(courseList);
        DepartmentTable.setItems(list);
    }
}
