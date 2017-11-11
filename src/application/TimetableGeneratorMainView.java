package application;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    public static AnchorPane rootP;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rootP = anchorpane;

        try {
            VBox box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (MouseEvent e) ->{
            transition.setRate(transition.getRate()*-1);
            transition.play();

            if(drawer.isShown())
            {
                drawer.close();
            }else
                drawer.open();
        });
    }
}
