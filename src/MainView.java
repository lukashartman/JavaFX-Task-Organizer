
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class MainView extends HBox {

    private VBox leftPane;
    private GridPane comingUpPane;

    public MainView (){

        leftPane = new LeftPane();
        comingUpPane = new ComingUpPane();
        leftPane.setPrefWidth(200);


        this.getChildren().addAll(leftPane, comingUpPane);
        this.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
    }

}
