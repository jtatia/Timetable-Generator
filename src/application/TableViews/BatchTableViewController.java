package application.TableViews;

import application.DatabaseUtils.BatchDAO;
import application.DatabaseUtils.DepartmentDAO;
import application.TimetableClasses.Batch;
import application.TimetableClasses.Department;
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

public class BatchTableViewController implements Initializable {

    @FXML
    private TableColumn<Batch, String> BatchTableDepartmentColumn;

    @FXML
    private AnchorPane BatchTableAnchorPane;

    @FXML
    private TableView<Batch> BatchTable;

    @FXML
    private TableColumn<Batch, String> BatchTableIDColumn;

    ObservableList<Batch> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Batch> deptList = (ArrayList<Batch>) BatchDAO.getAllBatches();
        list = FXCollections.observableArrayList(deptList);
        BatchTableDepartmentColumn.setCellValueFactory(new PropertyValueFactory<Batch,String>("department"));
        BatchTableIDColumn.setCellValueFactory(new PropertyValueFactory<Batch, String>("id"));
        BatchTable.setItems(list);
    }

    public void refreshTable()
    {
        ArrayList<Batch> courseList = (ArrayList<Batch>) BatchDAO.getAllBatches();
        list = FXCollections.observableArrayList(courseList);
        BatchTable.setItems(list);
    }
}
