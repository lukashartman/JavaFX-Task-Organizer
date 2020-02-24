
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
    private ScrollPane listVBoxHolder;
    private VBox listHolder;

    public LeftPane(){

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
        listVBoxHolder = new ScrollPane(listHolder);





        this.setPadding(new Insets(20,10,20,10));
        this.setSpacing(15);
        this.setBackground(new Background(new BackgroundFill(Color.POWDERBLUE, null, null)));
        this.getChildren().addAll(comingUpButton, addAssignmentButton, alignmentBox, listHolder);
        this.setAlignment(Pos.TOP_LEFT);


    }
}
