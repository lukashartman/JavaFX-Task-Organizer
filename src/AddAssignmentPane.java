import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.StageStyle;

public class AddAssignmentPane extends HBox {

    private Label assignmentTitleLabel, assignmentCourseLabel, assignmentDueDateLabel, assignmentsForCourseLabel;
    private TextField assingmentTitleField;
    private Button saveButton;
    private static ComboBox<String> courseSelectcb;
    private DatePicker datePicker;
    private LeftPane leftPane;
    private MainPane mainPane;
    private TodayPane todayPane;
    private VBox leftHalf, rightHalf;
    private Line dividerLine;


    public AddAssignmentPane(LeftPane leftPane, MainPane mainPane, TodayPane todayPane) {

        this.leftPane = leftPane;
        this.mainPane = mainPane;
        this.todayPane = todayPane;

        leftHalf = new VBox();
        leftHalf.setPadding(new Insets(15,5,5,15));
        leftHalf.setPrefWidth(350);
        leftHalf.setAlignment(Pos.TOP_CENTER);
        leftHalf.setSpacing(5);

        rightHalf = new VBox();
        rightHalf.setPadding(new Insets(5,5,5,15));
        rightHalf.setPrefWidth(350);

        assignmentTitleLabel = new Label("Title");
        assignmentTitleLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        assignmentTitleLabel.setTextFill(Color.BLACK);

        assignmentCourseLabel = new Label("Course");
        assignmentCourseLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        assignmentCourseLabel.setTextFill(Color.BLACK);

        assignmentDueDateLabel = new Label("Due Date");
        assignmentDueDateLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        assignmentDueDateLabel.setTextFill(Color.BLACK);

        assignmentsForCourseLabel = new Label("");
        assignmentsForCourseLabel.setFont(new Font("Avenir Next Condensed Bold", 20));
        assignmentsForCourseLabel.setTextFill(Color.BLACK);

        assingmentTitleField = new TextField();

        datePicker = new DatePicker();

        courseSelectcb = new ComboBox<>();
        updateCourseSelectcb();

        courseSelectcb.setPrefWidth(189);

        saveButton = new Button("Save");
        saveButton.getStyleClass().add("saveButton");

        dividerLine = new Line(350,0,350,400);

        this.setAlignment(Pos.CENTER);
        leftHalf.getChildren().addAll(assignmentTitleLabel, assingmentTitleField, assignmentCourseLabel, courseSelectcb, assignmentDueDateLabel, datePicker, saveButton);
        rightHalf.getChildren().addAll(assignmentsForCourseLabel);
        this.getChildren().addAll(leftHalf, dividerLine, rightHalf);
        saveButton.setOnAction(new SaveButtonHandler());
        courseSelectcb.setOnAction(new SelectionHandler());
    }

    private class SelectionHandler implements EventHandler<ActionEvent> {
        //Override the abstact method handle()
        public void handle(ActionEvent event) {
            if (courseSelectcb.getValue() != null ) {
                rightHalf.getChildren().removeIf(CheckBox.class::isInstance);

                for (int i = 0; i < Main.coursesList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.coursesList.get(i).getCourseTitle())) {
                        assignmentsForCourseLabel.setText("All " + courseSelectcb.getValue() + " Assignments");
                    }
                }

                for (int i = 0; i < Main.assignmentsList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.assignmentsList.get(i).getCourse().getCourseTitle())) {
                        rightHalf.getChildren().add(new CheckBox(Main.assignmentsList.get(i).getAssignmentName() + ": " + Main.assignmentsList.get(i).getDueDate()));
                    }
                }

            }else{
                assignmentsForCourseLabel.setText("Select Course");
            }
        }
    }

    public static void updateCourseSelectcb(){
        courseSelectcb.getItems().clear();

        for (int i = 0; i < Main.coursesList.size(); i++) {
            courseSelectcb.getItems().add(Main.coursesList.get(i).getCourseTitle());
        }
    }



    private class SaveButtonHandler implements EventHandler<ActionEvent> {

        //Override the abstact method handle()
        public void handle(ActionEvent event) {

            if (courseSelectcb.getSelectionModel().isEmpty() && datePicker.getValue()!=null && assingmentTitleField.getText()!=null) {
                for (int i = 0; i < Main.coursesList.size(); i++) {
                    if (courseSelectcb.getValue().equals(Main.coursesList.get(i).getCourseTitle())) {

                        Assignment tempAssignment = new Assignment(datePicker.getValue(), Main.coursesList.get(i), assingmentTitleField.getText());

                        Main.assignmentsList.add(tempAssignment);

                        System.out.println(Main.assignmentsList.toString() + "\n");

                        WeeklyPane.updateWeeklyPane();
                        TodayPane.updateTodayPane();
                        AllAssignmentsPane.updateAllAssignmentsPane();

                        courseSelectcb.setValue(null);
                        datePicker.setValue(null);
                        assingmentTitleField.clear();
                        break;
                    }
                }
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText("Please fill all fields and try again.");
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
            }
        }
    }
}
