package UIView;

import Model.Property;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static Controller.DatabaseController.properties;

public class PropertyView extends Application {
    public static Stage stage2;
    public static Scene createScene()
    {
        Scene scene;
        GridPane pane = new GridPane();
        Label label=new Label("All Properties");

        pane.getChildren().add(label);
        int i=2;
        for(Property property:properties)
        {
            Text text=new Text();
            text.setText(property.getInfo());
            text.setFont(new Font(18));
            pane.add(text,1,i);
            i++;
        }

        Button exit=new Button("Exit");
        exit.setOnAction(e->stage2.close());
        pane.add(exit,1,i+2);

        scene=new Scene(pane,800,500);
        return scene;
    }
    public static Scene createScene(String msg)
    {
        Scene scene;
        GridPane pane = new GridPane();
        Label label=new Label("All Properties");

        pane.getChildren().add(label);
        int i=2;
        for(Property property:properties)
        {
            Text text=new Text();
            text.setText(property.getInfo());
            text.setFont(new Font(18));
            pane.add(text,1,i);
            i++;
        }
        // TODO add msg to the pane
        Button exit=new Button("Exit");
        exit.setOnAction(e->stage2.close());
        pane.add(exit,1,i+2);

        scene=new Scene(pane,800,500);
        return scene;
    }
    public void getDisplayStage() {
        stage2 = new Stage();
        stage2.setTitle("Real Estate Management System");
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        stage2.setTitle("Property Manager");
        stage2.setScene(createScene());
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
            getDisplayStage();
            stage2.show();
    }
}