import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private HBox mainView;
    private ArrayList<Assignment> assignmentsList;
    private ArrayList<Course> coursesList;


    public void start(Stage stage1){

        assignmentsList = new ArrayList<Assignment>();
        coursesList = new ArrayList<Course>();
        mainView = new MainPane(assignmentsList, coursesList);

        Scene scene1 = new Scene(mainView, 900, 400);

        stage1.setScene(scene1);
        stage1.setTitle("Your Agenda");
        stage1.show();
    }

}
