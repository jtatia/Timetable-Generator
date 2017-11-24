package application;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TimetableGeneratorMainView implements Initializable{

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private SplitPane splitpane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {
            VBox left = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));

            String tablePath = "TableViews/CourseTableView.fxml";
            String formPath = "FormViews/CourseFormView.fxml";
            AnchorPane table = FXMLLoader.load(getClass().getResource(tablePath));
            AnchorPane form = FXMLLoader.load(getClass().getResource(formPath));

            splitpane.getItems().addAll(left,table,form);
            splitpane.setDividerPosition(0,1/(double)3);
            splitpane.setDividerPosition(1,2/(double)3);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
