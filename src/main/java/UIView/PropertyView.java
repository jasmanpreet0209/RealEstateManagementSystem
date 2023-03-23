package UIView;

import Model.Apartment;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class PropertyView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create a pane and set its properties
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        Button btOK = new Button("AddProperty");
        Button btCancel = new Button("Cancel");
        AddPropertyHandler addPropertyHandler = new AddPropertyHandler();
        btOK.setOnAction(addPropertyHandler);
        pane.getChildren().addAll(btOK, btCancel);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setTitle("HandleEvent"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage
    }
    class AddPropertyHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Apartment a = new Apartment(1,1,1,1,1);
            a.notifyTenant();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
