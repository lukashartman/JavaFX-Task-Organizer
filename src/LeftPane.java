
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

    public static Button weeklyButton, todayButton, viewAllButton, addAssignmentButton;
    private Label coursesLabel, titleLabel;
    private ScrollPane scrollingVBoxHolder;
    private VBox listHolderVBox;
    private MainPane mainPane;
    private HBox headerPane;

    public LeftPane(MainPane mainPane){

        this.mainPane = mainPane;

        //REMOVE ME EVENTUALLY
        Main.coursesList.add(new Course("CSE 205", "Navabi", "Life Sciences"));


        listHolderVBox = new VBox();
        scrollingVBoxHolder = new ScrollPane(listHolderVBox);
        scrollingVBoxHolder.getStyleClass().add("coursesScrollPane");

        weeklyButton = new Button("Weekly");
        weeklyButton.getStyleClass().add("sideButtons");

        todayButton = new Button("Today");
        todayButton.getStyleClass().add("sideButtons");

        viewAllButton = new Button("View All");
        viewAllButton.getStyleClass().add("sideButtons");

        addAssignmentButton = new Button("+ Task");
        addAssignmentButton.setPrefWidth(75);
        addAssignmentButton.setPrefHeight(25);
        addAssignmentButton.getStyleClass().add("newTaskButton");

        coursesLabel = new Label("Courses");
        coursesLabel.getStyleClass().add("coursesLabel");

        titleLabel = new Label("Agenda");
        titleLabel.setFont(new Font("Avenir Next Heavy", 30));
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setAlignment(Pos.CENTER);

        for (int i = 0; i < Main.coursesList.size(); i++) {
            listHolderVBox.getChildren().add(new CheckBox(Main.coursesList.get(i).toString()));
        }

        headerPane = new HBox();
        headerPane.getChildren().addAll(titleLabel, addAssignmentButton);
        headerPane.setSpacing(15);
        headerPane.setAlignment(Pos.CENTER);

        this.setPadding(new Insets(5,0,5,0));
        this.setSpacing(8);
        this.setBackground(new Background(new BackgroundFill(Color.rgb(0,11,149), null, null)));
        this.getChildren().addAll(headerPane, weeklyButton, todayButton, viewAllButton, coursesLabel, scrollingVBoxHolder);
        this.setAlignment(Pos.TOP_CENTER);

        //todayButton.setOnAction(event -> mainPane.showTodayPane());
        addAssignmentButton.setOnAction(event -> mainPane.showAddAssignmentPane());
        weeklyButton.setOnAction(event -> mainPane.showWeeklyPane());
        todayButton.setOnAction(event -> mainPane.showTodayPane());
        viewAllButton.setOnAction(event -> mainPane.showAllAssignmentsPane());
    }

    public void updateCoursesList() {
        System.out.println(Main.coursesList.size());
        listHolderVBox.getChildren().clear();
        for (int i = 0; i < Main.coursesList.size(); i++) {
            CheckBox tempCheck = new CheckBox(Main.coursesList.get(i).toString());
            listHolderVBox.getChildren().addAll(tempCheck);
            //tempCheck.setOnAction(); Set on action check
        }
    }

}
