package application.FormViews;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * Created by dell on 11/11/2017.
 */
public class CourseFormViewController {
    @FXML
    private Label CourseInputFormLabel;

    @FXML
    private Button DeleteButtonTextField;

    @FXML
    private TextField CourseCreditsTextField;

    @FXML
    private TextField CourseIdTextField;

    @FXML
    private TextField CourseNameTextField;

    @FXML
    private TextField CourseFrequencyTextField;

    @FXML
    private Button CourseButtonSubmitForm;

    @FXML
    private AnchorPane CourseFormAnchorView;
}
