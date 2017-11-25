package application;

import application.DatabaseUtils.TripletDAO;
import application.TimetableClasses.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sun.plugin.javascript.navig.Array;

import java.net.URL;
import java.util.*;

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

        TripletDAO dao = new TripletDAO();
        TimetableAlgorithm obj = new TimetableAlgorithm();

        List<ArrayList<TimetableSlots>> timeslots =  obj.createTimetable(dao.getAllTriplets());

        ArrayList<String> arr = new ArrayList<>(Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday"));
        for(int i=0;i<5;i++)
        {
            FinalTimetableRow r = new FinalTimetableRow();
            r.setDay(arr.get(i));
                r.setPeriod1(createPeriodString(timeslots.get(i).get(0)));
                r.setPeriod2(createPeriodString(timeslots.get(i).get(1)));
                r.setPeriod3(createPeriodString(timeslots.get(i).get(2)));
                r.setPeriod4(createPeriodString(timeslots.get(i).get(3)));
                r.setPeriod5(createPeriodString(timeslots.get(i).get(4)));
                r.setPeriod6(createPeriodString(timeslots.get(i).get(5)));
                list.add(r);

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

    public String createPeriodString(TimetableSlots slot){
        String period = "";
        for (int i=0;i<slot.getDoubletList().size();i++){
            if (slot.getDoubletList().get(i).getDTeacher().getTeacherName().length()>10)
            period += slot.getDoubletList().get(i).getDCourse().getCourseId()+"("+slot.getDoubletList().get(i).getDTeacher().getTeacherName().substring(0,slot.getDoubletList().get(i).getDTeacher().getTeacherName().indexOf(" "))+")\n";
            else
                period += slot.getDoubletList().get(i).getDCourse().getCourseId()+"("+slot.getDoubletList().get(i).getDTeacher().getTeacherName()+")\n";
            /*for (Batch batch : slot.getDoubletList().get(i).getDoubletBatchList()){
                period += batch.getId() + ", ";
            }
            period += ")\n";*/
        }
        return period;
    }
}
