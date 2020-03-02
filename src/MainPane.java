
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainPane extends HBox {

    private VBox leftPane;
    private GridPane comingUpPane, addAssignmentPane, editCoursesPane;
    private MainPane mainPane;

    public MainPane(ArrayList<Assignment> assignmentsList, ArrayList<Course> coursesList){

        leftPane = new LeftPane(coursesList, assignmentsList, this);
        comingUpPane = new ComingUpPane(assignmentsList);
        addAssignmentPane= new AddAssignmentPane(coursesList);
        editCoursesPane = new EditCoursesPane(coursesList);
        leftPane.setPrefWidth(200);

        this.getChildren().addAll(leftPane, comingUpPane);
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
        mainPane = this;
    }

    public void editCourses(){
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(leftPane, addAssignmentPane);
    }

}

