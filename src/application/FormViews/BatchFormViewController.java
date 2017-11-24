package application.FormViews;

import application.DatabaseUtils.BatchDAO;
import application.TableViews.BatchTableViewController;
import application.TimetableClasses.Batch;
import application.TimetableClasses.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class BatchFormViewController {

    @FXML
    private TextField BatchIdTextField;

    @FXML
    private Button BatchButtonSubmitForm;

    @FXML
    private Button DeleteButtonTextField;

    @FXML
    private Label BatchFormHeading;

    @FXML
    private TextField DepartmentIdTextField;

    @FXML
    void onSubmitAction(ActionEvent event) throws IOException {
        String deptId=BatchIdTextField.getText();
        String deptName= DepartmentIdTextField.getText();
        Batch department = new Batch(deptId,deptName);
        BatchDAO.insertBatch(department);

    }
}
