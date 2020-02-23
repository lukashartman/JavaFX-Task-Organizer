import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeftPane extends VBox {

    private Button comingUpButton;

    public LeftPane(){

        comingUpButton = new Button("Coming Up");

        this.getChildren().addAll(comingUpButton);


    }
}
