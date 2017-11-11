package application.TableViews;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class DepartmentTableViewController {

    @FXML
    private AnchorPane DepartmentTableAnchorPane;

    @FXML
    private TableColumn<?, ?> DepartmentNameColumn;

    @FXML
    private TableColumn<?, ?> DepartmentIDColumn;

    @FXML
    private TableView<?> DepartmentTable;
}
