
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainPane extends HBox {

    private LeftPane leftPane;
    private VBox editCoursesPane, addAssignmentPane;
    private GridPane weeklyPane;
    private MainPane mainPane;
    private TodayPane todayPane;

    public MainPane(){
        Main.assignmentsList = new ArrayList<Assignment>();
        Main.coursesList = new ArrayList<Course>();

        leftPane = new LeftPane(this);
        weeklyPane = new WeeklyPane(leftPane, this);
        todayPane = new TodayPane(leftPane, this);
        addAssignmentPane= new AddAssignmentPane(leftPane, this, todayPane);
        editCoursesPane = new EditCoursesPane(leftPane, this);
        leftPane.setPrefWidth(243);

        this.getChildren().addAll(leftPane, weeklyPane);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        mainPane = this;

    }

    public void showUpdateCoursesPane(){
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(leftPane, editCoursesPane);
    }

    public void showWeeklyPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();

        LeftPane.weeklyButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        mainPane.getChildren().addAll(leftPane, weeklyPane);

    }

    public void showAddAssignmentPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();

        LeftPane.todayButton.getStyleClass().setAll("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");

        mainPane.getChildren().addAll(leftPane, addAssignmentPane);
    }
    public void showTodayPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();

        LeftPane.todayButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");

        mainPane.getChildren().addAll(leftPane, todayPane);
    }
    public void showAllAssignmentsPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();

        LeftPane.viewAllButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");

        mainPane.getChildren().addAll(leftPane);
    }


}

