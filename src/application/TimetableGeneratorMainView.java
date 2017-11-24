package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimetableGeneratorMainView implements Initializable{

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private SplitPane splitpane;

    private VBox left;

    private String tablePath = "TableViews/CourseTableView.fxml";
    private String formPath = "FormViews/CourseFormView.fxml";

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
    public void initialize(URL location, ResourceBundle resources) {

        try {

            addSplits();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    private void removeSplits() {
        Node component1 = splitpane.getItems().get(1);
        Node component2 = splitpane.getItems().get(2);

        splitpane.getItems().remove(component1);
        splitpane.getItems().remove(component2);

    }

    @FXML
    private void setDepartment(ActionEvent event) throws IOException {

        tablePath = "TableViews/DepartmentTableView.fxml";
        formPath = "";
        removeSplits();
        addSplits();
    }

    @FXML
    private void setBatch(ActionEvent event) throws IOException {

        tablePath = "TableViews/BatchTableView.fxml";
        formPath = "";
        removeSplits();
        addSplits();
    }

    @FXML
    private void setTeacher(ActionEvent event) throws IOException {

        tablePath = "TableViews/TeacherTableView.fxml";
        formPath = "FormViews/TeacherFormView.fxml";
        removeSplits();
        addSplits();
    }

    @FXML
    private void setCourse(ActionEvent event) throws IOException {

        tablePath = "TableViews/CourseTableView.fxml";
        formPath = "FormViews/CourseFormView.fxml";
        removeSplits();
        addSplits();
    }

    @FXML
    private void generateTable(ActionEvent event){

    }

    private void addSplits() throws IOException {
        AnchorPane table = FXMLLoader.load(getClass().getResource(tablePath));
        AnchorPane form = FXMLLoader.load(getClass().getResource(formPath));

        splitpane.getItems().addAll(table,form);

        splitpane.setDividerPosition(0,1/(double)3);
        splitpane.setDividerPosition(1,2/(double)3);

    }


}
