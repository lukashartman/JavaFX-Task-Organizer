
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainPane extends HBox {

    private LeftPane leftPane;
    private VBox editCoursesPane;
    private GridPane comingUpPane, addAssignmentPane;
    private MainPane mainPane;

    public MainPane(){
        Main.assignmentsList = new ArrayList<Assignment>();
        Main.coursesList = new ArrayList<Course>();

        leftPane = new LeftPane(this);
        comingUpPane = new ComingUpPane();
        addAssignmentPane= new AddAssignmentPane();
        editCoursesPane = new EditCoursesPane(leftPane, this);
        leftPane.setPrefWidth(200);

        this.getChildren().addAll(leftPane, comingUpPane);
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
        mainPane = this;

    }

    public void showUpdateCoursesPane(){
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(leftPane, editCoursesPane);
    }

    public void showComingUpPane(){
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(leftPane, comingUpPane);
    }

    public void showAddAssignmentPane(){
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(leftPane, addAssignmentPane);
    }

}

