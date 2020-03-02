import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private ArrayList<Assignment> assignmentsList;
    private ArrayList<Course> coursesList;

    private Stage window;
    private Scene scene1;
    private HBox mainPane;


    public static void main(String[] args){
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception{
        window = primaryStage;
        assignmentsList = new ArrayList<Assignment>();
        coursesList = new ArrayList<Course>();
        mainPane = new MainPane(assignmentsList, coursesList);

        scene1 = new Scene(mainPane, 900, 400);

        window.setScene(scene1);
        window.setTitle("Your Agenda");
        window.show();
    }

}
