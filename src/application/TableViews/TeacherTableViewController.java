package application.TableViews;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * Created by dell on 11/11/2017.
 */
public class TeacherTableViewController {
    @FXML
    private TableColumn<?, ?> TeacherNameColumn;

    @FXML
    private AnchorPane TeacherViewAnchorPane;

    @FXML
    private TableView<?> TeacherTableView;

    @FXML
    private TableColumn<?, ?> TeacherColumn;

    @FXML
    private TableColumn<?, ?> TeacherDepartmentColumn;
}
