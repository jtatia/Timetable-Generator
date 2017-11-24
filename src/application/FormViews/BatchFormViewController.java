package application.FormViews;

import application.DatabaseUtils.BatchDAO;
import application.TimetableClasses.Batch;
import application.TimetableClasses.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    void onSubmitAction(ActionEvent event) {
        String deptId=BatchIdTextField.getText();
        String deptName= DepartmentIdTextField.getText();
        Batch department = new Batch(deptId,deptName);
        BatchDAO.insertBatch(department);
        BatchIdTextField.setText("");
        DepartmentIdTextField.setText("");
    }
}
