import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EditCoursesPane extends VBox {

    private Label courseTitleLabel, courseProfessorLabel, courseLocationLabel;
    private TextField courseTitleField, courseProfessorField, courseLocationField;
    private Button saveButton, exitButton;
    private GridPane inputInfoPane;
    private VBox leftPane;
    private MainPane mainPane;

    public EditCoursesPane(LeftPane leftPane, MainPane mainPane) {

        this.leftPane = leftPane;
        this.mainPane = mainPane;

        courseTitleLabel = new Label("Title");
        courseProfessorLabel = new Label("Professor");
        courseLocationLabel = new Label("Location");

        courseTitleField = new TextField();
        courseProfessorField = new TextField();
        courseLocationField = new TextField();

        saveButton = new Button("Save");
        exitButton = new Button("Exit");

        inputInfoPane = new GridPane();
        inputInfoPane.setHgap(15);
        inputInfoPane.setVgap(5);

        inputInfoPane.add(courseTitleLabel, 0,0);
        inputInfoPane.add(courseProfessorLabel, 0,1);
        inputInfoPane.add(courseLocationLabel, 0,2);

        inputInfoPane.add(courseTitleField, 1,0);
        inputInfoPane.add(courseProfessorField, 1,1);
        inputInfoPane.add(courseLocationField, 1,2);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(inputInfoPane, saveButton, exitButton);

        saveButton.setOnAction(new SaveButtonHandler(leftPane));
        exitButton.setOnAction(event -> mainPane.showWeeklyPane());
    }

    private class SaveButtonHandler implements EventHandler<ActionEvent>
    {
        private LeftPane leftPane;
        public SaveButtonHandler(LeftPane leftPane) {
            this.leftPane = leftPane;
        }

        //Override the abstact method handle()
        public void handle(ActionEvent event) {
            Course tempCourse = new Course(courseTitleField.getText(), courseProfessorField.getText(), courseLocationField.getText());
            Main.coursesList.add(tempCourse);
            System.out.println(Main.coursesList.size());
            leftPane.updateCoursesList();
        }
    }
}
