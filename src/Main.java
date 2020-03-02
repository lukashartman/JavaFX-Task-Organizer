import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<Assignment> assignmentsList;
    public static ArrayList<Course> coursesList;

    private Stage window;
    private Scene scene1;
    private HBox mainPane;


    public static void main(String[] args){
        launch(args);
    }

    public void start (Stage primaryStage) throws Exception{


        window = primaryStage;
        mainPane = new MainPane();

        scene1 = new Scene(mainPane, 900, 400);

        window.setScene(scene1);
        window.setTitle("Your Agenda");
        window.show();
    }

}
