package application.FormViews;

import application.DatabaseUtils.BatchDAO;
import application.DatabaseUtils.CourseBatchDAO;
import application.TimetableClasses.Batch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private Button AddButton;

    @FXML
    private TextField CourseIdTextField;

    @FXML
    private TextArea CoursesTextArea;

    @FXML
    void onSubmitAction(ActionEvent event) {
        String deptId=BatchIdTextField.getText();
        String deptName= DepartmentIdTextField.getText();
        String courseTextArea=CoursesTextArea.getText();
        String list[]=courseTextArea.split("\n");
        Batch department = new Batch(deptId,deptName);
        BatchDAO.insertBatch(department);
        for(String k:list)
        {
            CourseBatchDAO.insertCourseBatchRecord(k,deptId);
        }
        BatchIdTextField.setText("");
        DepartmentIdTextField.setText("");
        CoursesTextArea.setText("");
        CourseIdTextField.setText("");
    }

    @FXML
    void onAddAction(ActionEvent event) {
        String courseId=CourseIdTextField.getText();
        CourseIdTextField.setText("");
        String textAreaString=CoursesTextArea.getText();
        textAreaString+=courseId+"\n";
        CoursesTextArea.setText(textAreaString);
    }

}
