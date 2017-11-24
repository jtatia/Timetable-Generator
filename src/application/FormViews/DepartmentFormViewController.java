package application.FormViews;

import application.DatabaseUtils.DepartmentDAO;
import application.TimetableClasses.Department;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class DepartmentFormViewController {

    @FXML
    private AnchorPane DeptFormAnchorView;

    @FXML
    private Button DeleteButtonTextField;

    @FXML
    private TextField DeptIdTextField;

    @FXML
    private Label DeptFormHeading;

    @FXML
    private Button DeptButtonSubmitForm;

    @FXML
    private TextField DeptNameTextField;

    @FXML
    void onSubmitAction(ActionEvent event) {
        String deptId=DeptIdTextField.getText();
        String deptName=DeptNameTextField.getText();
        Department department = new Department(deptId,deptName);
        DepartmentDAO.insertDepartment(department);
    }

}
