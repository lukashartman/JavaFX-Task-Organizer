
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainPane extends HBox {

    private VBox leftPane;
    private GridPane comingUpPane, addAssignment;

    public MainPane(ArrayList<Assignment> assignmentsList, ArrayList<Course> coursesList){

        leftPane = new LeftPane(coursesList, assignmentsList);
        comingUpPane = new ComingUpPane(assignmentsList);
        addAssignment = new AddAssignmentPane(coursesList);
        leftPane.setPrefWidth(200);

        this.getChildren().addAll(leftPane, comingUpPane);
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));

    }


}

