package UIView;

import Model.Apartment;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Objects;

public class PropertyView extends Application {
    @Override
    public void start(Stage stage) {
        // Create a pane and set its properties
        Button addProperty = new Button("Add Property");
        Button viewProperty = new Button("View Property");
        Button addTenant = new Button("Add Tenant");
        Button viewTenants = new Button("Display Tenants");
        Button displayRentedUnits = new Button("Display Rented Units");
        Button displayVacantUnits = new Button("Display Vacant Units");
        Button displayLeases = new Button("Display Leases");

        AddPropertyHandler addPropertyHandler = new AddPropertyHandler();
        addProperty.setOnAction(addPropertyHandler);

        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        StackPane.setMargin(addProperty, new Insets(40, 140, 160, 10));
        StackPane.setMargin(viewProperty, new Insets(40, 10, 160, 180));
        StackPane.setMargin(addTenant, new Insets(80, 140, 120, 10));
        StackPane.setMargin(viewTenants, new Insets(80, 5, 120, 180));
        StackPane.setMargin(displayRentedUnits, new Insets(120, 140, 80, 10));
        StackPane.setMargin(displayVacantUnits, new Insets(120, 10, 80, 180));
        StackPane.setMargin(displayLeases, new Insets(160, 140, 40, 10));
        stackPane.getChildren().addAll(addProperty,viewProperty,addTenant,viewTenants,displayRentedUnits,displayVacantUnits,displayLeases);

        // Create a scene and place it in the stage
        Scene scene1 = new Scene(stackPane);
        stage.setTitle("Property Manager"); // Set the stage title
        stage.setScene(scene1); // Place the scene in the stage
        stackPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            if(!Objects.equals(newVal, oldVal)){
                stackPane.minWidthProperty().bind(stackPane.heightProperty().multiply(1.77778));
                stackPane.maxWidthProperty().bind(stackPane.heightProperty().multiply(1.77778));
            }
        });
        stackPane.heightProperty().addListener((obs, oldVal, newVal) -> {
            if(!Objects.equals(newVal, oldVal)){
                stackPane.minWidthProperty().bind(stackPane.heightProperty().multiply(1.77778));
                stackPane.maxWidthProperty().bind(stackPane.heightProperty().multiply(1.77778));
            }
        });
        stage.show(); // Display the stage
    }
    static class AddPropertyHandler implements EventHandler<ActionEvent> {
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
