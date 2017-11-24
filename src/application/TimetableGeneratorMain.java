package application;

import application.DatabaseUtils.DatabaseConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TimetableGeneratorMain extends Application {

    public static void main(String[] args) {
        DatabaseConnection.openConnection();
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Timetable Generator");
        try {
            showMainView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMainView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TimetableGeneratorMain.class.getResource("TimetableGeneratorMainView.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);
    }
}
