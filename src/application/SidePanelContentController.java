package application;



import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class SidePanelContentController implements Initializable {


    @FXML
    private VBox vbox;

    @FXML
    private Button Department;

    @FXML
    private Button Batch;

    @FXML
    private Button Teacher;

    @FXML
    private Button Course;

    @FXML
    private Button generate;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void setDepartment(ActionEvent event) throws IOException {

        String tablePath = "TableViews/DepartmentTableView.fxml";
        String formPath = "";
        changeViews(tablePath,formPath);
    }

    @FXML
    private void setBatch(ActionEvent event) throws IOException {

        String tablePath = "TableViews/BatchTableView.fxml";
        String formPath = "";
        changeViews(tablePath,formPath);
    }

    @FXML
    private void setTeacher(ActionEvent event) throws IOException {

        String tablePath = "TableViews/TeacherTableView.fxml";
        String formPath = "FormViews/TeacherFormView.fxml";
        changeViews(tablePath,formPath);
    }

    @FXML
    private void setCourse(ActionEvent event) throws IOException {

        String tablePath = "TableViews/CourseTableView.fxml";
        String formPath = "FormViews/CourseFormView.fxml";
        changeViews(tablePath,formPath);
    }

    @FXML
    private void generateTable(ActionEvent event){

    }

    private void changeViews(String tablePath,String formPath) throws IOException {
        AnchorPane table = FXMLLoader.load(getClass().getResource(tablePath));
        AnchorPane form = FXMLLoader.load(getClass().getResource(formPath));
        SplitPane splitPane = (SplitPane) vbox.getParent();
        splitPane.getItems().set(1,table);
        splitPane.getItems().set(2,form);
    }
}
