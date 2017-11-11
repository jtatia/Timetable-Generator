package application.TableViews;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CourseTableViewController {

    @FXML
    private AnchorPane CourseTableAnchorPane;

    @FXML
    private TableView<?> CourseTable;

    @FXML
    private TableColumn<?, ?> CourseTableCreditColumn;

    @FXML
    private TableColumn<?, ?> CourseTableIDColumn;

    @FXML
    private TableColumn<?, ?> CourseTableNameColumn;

    @FXML
    private TableColumn<?, ?> CourseTableFrequencyColumn;
}
