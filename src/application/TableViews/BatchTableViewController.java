package application.TableViews;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class BatchTableViewController {

    @FXML
    private TableColumn<?, ?> BatchTableDepartmentColumn;

    @FXML
    private AnchorPane BatchTableAnchorPane;

    @FXML
    private TableView<?> BatchTable;

    @FXML
    private TableColumn<?, ?> BatchTableIDColumn;
}
