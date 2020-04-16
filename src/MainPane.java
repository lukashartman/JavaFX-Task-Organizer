
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainPane extends HBox {

    private LeftPane leftPane;
    private HBox editCoursesPane, addAssignmentPane;
    private WeeklyPane weeklyPane;
    private MainPane mainPane;
    private TodayPane todayPane;
    private AllAssignmentsPane allAssignmentsPane;

    public MainPane(){

        leftPane = new LeftPane(this);
        weeklyPane = new WeeklyPane(leftPane, this);
        todayPane = new TodayPane(leftPane, this);
        addAssignmentPane= new AddAssignmentPane(leftPane, this, todayPane);
        editCoursesPane = new EditCoursesPane(leftPane, this);
        allAssignmentsPane = new AllAssignmentsPane(leftPane, this);
        leftPane.setPrefWidth(243);

        this.getChildren().addAll(leftPane, weeklyPane);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        mainPane = this;

    }

    public void showWeeklyPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        LeftPane.weeklyButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");
        mainPane.getChildren().addAll(leftPane, weeklyPane);

    }

    public void showAddAssignmentPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        LeftPane.todayButton.getStyleClass().setAll("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        mainPane.getChildren().addAll(leftPane, addAssignmentPane);
    }
    public void showTodayPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        LeftPane.todayButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        mainPane.getChildren().addAll(leftPane, todayPane);
    }
    public void showAllAssignmentsPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        LeftPane.viewAllButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");


        mainPane.getChildren().addAll(leftPane, allAssignmentsPane);
    }

    public void showEditCoursesPane(){
        mainPane.getChildren().clear();

        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        LeftPane.coursesButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");


        mainPane.getChildren().addAll(leftPane, editCoursesPane);
    }


}

