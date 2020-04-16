
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LeftPane extends VBox {

    public static Button weeklyButton, todayButton, viewAllButton, coursesButton, addAssignmentButton;
    private Label titleLabel;
    private MainPane mainPane;
    private HBox headerPane;

    public LeftPane(MainPane mainPane){

        this.mainPane = mainPane;

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

        titleLabel = new Label("Agenda");
        titleLabel.setFont(new Font("Avenir Next Heavy", 30));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);

        headerPane = new HBox();
        headerPane.getChildren().addAll(titleLabel, addAssignmentButton);
        headerPane.setSpacing(15);
        headerPane.setAlignment(Pos.CENTER);

        this.setPadding(new Insets(5,0,5,0));
        this.setSpacing(8);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(0,11,149), null, null)));
        this.getChildren().addAll(headerPane, weeklyButton, todayButton, viewAllButton, coursesButton);
        this.setAlignment(Pos.TOP_CENTER);

        //todayButton.setOnAction(event -> mainPane.showTodayPane());
        addAssignmentButton.setOnAction(event -> mainPane.showAddAssignmentPane());
        weeklyButton.setOnAction(event -> mainPane.showWeeklyPane());
        todayButton.setOnAction(event -> mainPane.showTodayPane());
        viewAllButton.setOnAction(event -> mainPane.showAllAssignmentsPane());
        coursesButton.setOnAction(event -> mainPane.showEditCoursesPane());
    }

}
