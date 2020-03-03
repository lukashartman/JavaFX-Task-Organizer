import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.time.LocalDate;

public class AddAssignmentPane extends VBox {

    private Label assignmentTitleLabel, assignmentCourseLabel, assignmentDueDateLabel;
    private TextField assingmentTitleField;
    private Button saveButton, exitButton;
    private GridPane inputInfoPane;
    private ComboBox<String> courseSelectcb;
    private DatePicker datePicker;
    private LeftPane leftPane;
    private MainPane mainPane;
    private TodayPane todayPane;

    public AddAssignmentPane(LeftPane leftPane, MainPane mainPane, TodayPane todayPane) {

        this.leftPane = leftPane;
        this.mainPane = mainPane;
        this.todayPane = todayPane;

        assignmentTitleLabel = new Label("Title");
        assignmentCourseLabel = new Label("Course");
        assignmentDueDateLabel = new Label("Due Date");

        assingmentTitleField = new TextField();

        datePicker = new DatePicker();

        courseSelectcb = new ComboBox<>();
        for (int i = 0; i < Main.coursesList.size(); i++) {
            courseSelectcb.getItems().add(Main.coursesList.get(i).getCourseTitle());
        }

        courseSelectcb.setValue(null);
        courseSelectcb.setPrefWidth(189);

        saveButton = new Button("Save");
        exitButton = new Button("Exit");

        inputInfoPane = new GridPane();
        inputInfoPane.setHgap(15);
        inputInfoPane.setVgap(5);

        inputInfoPane.add(assignmentTitleLabel, 0, 0);
        inputInfoPane.add(assignmentCourseLabel, 0, 1);
        inputInfoPane.add(assignmentDueDateLabel, 0, 2);

        inputInfoPane.add(assingmentTitleField, 1, 0);
        inputInfoPane.add(courseSelectcb, 1, 1);
        inputInfoPane.add(datePicker, 1, 2);


        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(inputInfoPane, saveButton, exitButton);

        saveButton.setOnAction(new SaveButtonHandler());
        exitButton.setOnAction(event -> mainPane.showWeeklyPane());
    }

    private class SaveButtonHandler implements EventHandler<ActionEvent> {

        //Override the abstact method handle()
        public void handle(ActionEvent event) {

            Course tempCourse = null;
            for (int i = 0; i < Main.coursesList.size(); i++) {
                if (courseSelectcb.getValue().equals(Main.coursesList.get(i).getCourseTitle())) {
                    tempCourse = Main.coursesList.get(i);
                    Assignment tempAssignment = new Assignment(datePicker.getValue(), tempCourse, assingmentTitleField.getText());
                    Main.assignmentsList.add(tempAssignment);
                    System.out.println(Main.assignmentsList.toString());
                    todayPane.updateAssignmentsToday(tempAssignment);
                    break;
                }
            }
        }
    }
}
