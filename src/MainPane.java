
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MainPane extends HBox {

    //Instance variables
    private LeftPane leftPane;
    private AddAssignmentPane addAssignmentPane;
    private EditCoursesPane editCoursesPane;
    private WeeklyPane weeklyPane;
    private MainPane mainPane;
    private TodayPane todayPane;
    private AllAssignmentsPane allAssignmentsPane;

    public MainPane() {

        //Setup and create all panes
        mainPane = this;
        leftPane = new LeftPane(this);
        weeklyPane = new WeeklyPane();
        todayPane = new TodayPane();
        addAssignmentPane = new AddAssignmentPane();
        editCoursesPane = new EditCoursesPane();
        allAssignmentsPane = new AllAssignmentsPane();
        leftPane.setPrefWidth(243);

        //Setup this pane to start with default views
        this.getChildren().addAll(leftPane, weeklyPane);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

    }

    //Method to display weekly pane
    public void showWeeklyPane() {

        //Clear the pane
        mainPane.getChildren().clear();

        //Clear button styles
        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        //Set new button styles
        LeftPane.weeklyButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        //Add new panes to this pane
        mainPane.getChildren().addAll(leftPane, weeklyPane);

    }

    //Method to display add assignment pane
    public void showAddAssignmentPane() {

        //Clear the pane
        mainPane.getChildren().clear();

        //Clear button styles
        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        //Set new button styles
        LeftPane.todayButton.getStyleClass().setAll("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        //Add new panes to this pane
        mainPane.getChildren().addAll(leftPane, addAssignmentPane);
    }

    //Method to display today/tomorrow pane
    public void showTodayPane() {

        //Clear the pane
        mainPane.getChildren().clear();

        //Clear button styles
        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        //Set new button styles
        LeftPane.todayButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        //Add new panes to this pane
        mainPane.getChildren().addAll(leftPane, todayPane);
    }

    //Method to display view all pane
    public void showAllAssignmentsPane() {

        //Clear the pane
        mainPane.getChildren().clear();

        //Clear button styles
        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        //Set new button styles
        LeftPane.viewAllButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.coursesButton.getStyleClass().add("sideButtons");

        //Add new panes to this pane
        mainPane.getChildren().addAll(leftPane, allAssignmentsPane);
    }

    //Method to display courses pane=
    public void showEditCoursesPane() {
        //Clear the pane
        mainPane.getChildren().clear();

        //Clear button styles
        LeftPane.weeklyButton.getStyleClass().clear();
        LeftPane.todayButton.getStyleClass().clear();
        LeftPane.viewAllButton.getStyleClass().clear();
        LeftPane.coursesButton.getStyleClass().clear();

        //Set new button styles
        LeftPane.coursesButton.getStyleClass().setAll("activeSideButtons");
        LeftPane.todayButton.getStyleClass().add("sideButtons");
        LeftPane.weeklyButton.getStyleClass().add("sideButtons");
        LeftPane.viewAllButton.getStyleClass().add("sideButtons");

        //Add new panes to this pane
        mainPane.getChildren().addAll(leftPane, editCoursesPane);
    }


}

