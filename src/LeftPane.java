import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LeftPane extends VBox {

    //Create static variables
    public static Button weeklyButton, todayButton, viewAllButton, coursesButton, addAssignmentButton;
    private Label titleLabel;
    private MainPane mainPane;
    private HBox headerPane;

    public LeftPane(MainPane mainPane){

        //Pass mainpane to call methods from it later
        this.mainPane = mainPane;

        //Setup all buttons and assign styles
        weeklyButton = new Button("Weekly");
        weeklyButton.getStyleClass().add("activeSideButtons");

        todayButton = new Button("Today");
        todayButton.getStyleClass().add("sideButtons");

        viewAllButton = new Button("View All");
        viewAllButton.getStyleClass().add("sideButtons");

        addAssignmentButton = new Button("+ Task");
        addAssignmentButton.getStyleClass().add("newTaskButton");

        coursesButton = new Button("Courses");
        coursesButton.getStyleClass().add("sideButtons");

        //Set all labels and assign styles
        titleLabel = new Label("Agenda");
        titleLabel.setFont(new Font("Avenir Next Heavy", 30));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);

        //Setup header box to hold title label and add assignment button
        headerPane = new HBox();
        headerPane.getChildren().addAll(titleLabel, addAssignmentButton);
        headerPane.setSpacing(15);
        headerPane.setAlignment(Pos.CENTER);

        //Setup leftPane and add relevant nodes
        this.setPadding(new Insets(5,0,5,0));
        this.setSpacing(8);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(0,11,149), null, null)));
        this.getChildren().addAll(headerPane, weeklyButton, todayButton, viewAllButton, coursesButton);
        this.setAlignment(Pos.TOP_CENTER);

        //Assign all buttons to call methods from mainpane
        addAssignmentButton.setOnAction(event -> mainPane.showAddAssignmentPane());
        weeklyButton.setOnAction(event -> mainPane.showWeeklyPane());
        todayButton.setOnAction(event -> mainPane.showTodayPane());
        viewAllButton.setOnAction(event -> mainPane.showAllAssignmentsPane());
        coursesButton.setOnAction(event -> mainPane.showEditCoursesPane());
    }

}
