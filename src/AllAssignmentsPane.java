import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class AllAssignmentsPane extends VBox {

    //Instance variables
    public static VBox allItemsVBox;
    private Label allAssignmentsLabel;

    public AllAssignmentsPane() {

        //Setup label with correct style
        allAssignmentsLabel = new Label("All Assignments");
        allAssignmentsLabel.getStyleClass().add("todayViewHeaderLabels");

        //Setup vbox to hold all assignments and add label
        allItemsVBox = new VBox(allAssignmentsLabel);
        allItemsVBox.setPrefWidth(350);

        //Call method to add most recent list of assignments to pane
        updateAllAssignmentsPane();

        //Setup pane with spacing and children
        this.setPadding(new Insets(15, 5, 5, 15));
        this.getChildren().addAll(allAssignmentsLabel, allItemsVBox);

    }

    //Method to update the assignments in this pane
    public static void updateAllAssignmentsPane() {

        //Remove all checkboxes from VBox
        allItemsVBox.getChildren().removeIf(CheckBox.class::isInstance);

        //Cycle through assignments list and create new checkboxes for all assignments
        for (int i = 0; i < Main.assignmentsList.size(); i++) {
            allItemsVBox.getChildren().add(new CheckBox(Main.assignmentsList.get(i).toString()));
        }
    }
}
