import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class AllAssignmentsPane extends VBox {

    private LeftPane leftPane;
    private MainPane mainPane;
    public static VBox allItemsVBox;
    private Label allAssignmentsLabel;

    public AllAssignmentsPane(LeftPane leftPane, MainPane mainPane) {
        this.mainPane = mainPane;
        this.leftPane = leftPane;

        allAssignmentsLabel = new Label("All Assignments");
        allAssignmentsLabel.getStyleClass().add("todayViewHeaderLabels");


        allItemsVBox = new VBox(allAssignmentsLabel);
        allItemsVBox.setPrefWidth(350);

        this.setPadding(new Insets(15, 5, 5, 15));

        this.getChildren().addAll(allAssignmentsLabel, allItemsVBox);

    }

    public static void updateAllAssignmentsPane() {
        allItemsVBox.getChildren().removeIf(CheckBox.class::isInstance);

        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            allItemsVBox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
        }
    }
}
