package application;

import application.TimetableClasses.FinalTimetableRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class FinalTimetableViewController implements Initializable {

    @FXML
    private AnchorPane BatchTableAnchorPane;

    @FXML
    private TableView<FinalTimetableRow> TimeTable;

    @FXML
    private TableColumn<FinalTimetableRow, String> period4;

    @FXML
    private TableColumn<FinalTimetableRow, String> period3;

    @FXML
    private TableColumn<FinalTimetableRow, String> period2;

    @FXML
    private TableColumn<FinalTimetableRow, String> period1;

    @FXML
    private TableColumn<FinalTimetableRow, String> day;

    @FXML
    private TableColumn<FinalTimetableRow, String> period6;

    @FXML
    private TableColumn<FinalTimetableRow, String> period5;

    ObservableList<FinalTimetableRow> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // populate the list

        for(int i=0;i<5;i++)
        {
            FinalTimetableRow r = new FinalTimetableRow();
            r.setDay("Monday");
            r.setPeriod1("CS355, CS455");
            r.setPeriod2("CS355, CS455");
            r.setPeriod3("CS355, CS455");
            r.setPeriod4("CS355, CS455");
            r.setPeriod5("CS355, CS455");
            r.setPeriod6("CS355, CS455");
            list.add(r);
        }


        // code till here (dummy data)

        day.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("day"));
        period1.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period1"));
        period2.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period2"));
        period3.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period3"));
        period4.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period4"));
        period5.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period5"));
        period6.setCellValueFactory(new PropertyValueFactory<FinalTimetableRow,String>("period6"));

        TimeTable.setItems(list);

    }
}
