
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LeftPane extends VBox {

    private Button comingUpButton, addAssignmentButton, editButton;
    private Label classesLabel;
    private HBox alignmentBox;
    private ScrollPane scrollingVBoxHolder;
    private VBox listHolder;
    private MainPane mainPane;

    public LeftPane(MainPane mainPane){

        this.mainPane = mainPane;

        comingUpButton = new Button("Coming Up");
        comingUpButton.setPrefWidth(400);

        addAssignmentButton = new Button("Add Assignment");
        addAssignmentButton.setPrefWidth(400);

        alignmentBox = new HBox(10);
        alignmentBox.setAlignment(Pos.BOTTOM_LEFT);

        classesLabel = new Label("Classes");
        classesLabel.setFont(new Font(20));

        editButton = new Button("Edit");
        editButton.setFont(new Font(10));
        alignmentBox.getChildren().addAll(classesLabel, editButton);

        listHolder = new VBox(2);
        scrollingVBoxHolder = new ScrollPane(listHolder);
        scrollingVBoxHolder.setPrefHeight(400);

        for (int i = 0; i < Main.coursesList.size(); i++) {
            listHolder.getChildren().add(new Label(Main.coursesList.get(i).toString()));
        }

        this.setPadding(new Insets(20,10,20,10));
        this.setSpacing(15);
        this.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, null, null)));
        this.getChildren().addAll(comingUpButton, addAssignmentButton, alignmentBox, scrollingVBoxHolder);
        this.setAlignment(Pos.TOP_LEFT);

        editButton.setOnAction(event -> mainPane.showUpdateCoursesPane());
        addAssignmentButton.setOnAction(event -> mainPane.showAddAssignmentPane());
        comingUpButton.setOnAction(event -> mainPane.showComingUpPane());

    }

    public void updateCoursesList(){
        System.out.println(Main.coursesList.size());
        listHolder.getChildren().clear();
        for (int i = 0; i < Main.coursesList.size(); i++) {
            listHolder.getChildren().addAll(new Label(Main.coursesList.get(i).toString()));
        }
    }

}
