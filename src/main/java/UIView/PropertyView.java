package UIView;

import Controller.PropertiesController;
import Controller.*;
import Model.*;
import javafx.application.Application;

import static Controller.MockDatabaseController.tenants;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import Controller.MockDatabaseController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class PropertyView extends Application {
    MockDatabaseController mc=MockDatabaseController.getInstance();
    PropertiesController pc=new PropertiesController();
    TenantController tc=new TenantController();
    LeaseController lc=new LeaseController();
    Scene scene0,sceneAddProperty,sceneAddTenant,sceneDisplayTenant,sceneDisplayRented,
            sceneDisplayVacant,sceneDisplayLease,sceneAddApartment,sceneAddApartmentBuilding,sceneAddCondoBuilding,sceneAddCondo
            ,sceneAddHouse;
    Stage window;
    void addApartmentBuilding(){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(0.2);
        pane.setHgap(0.2);
        Label building = new Label("Building name: ");
        TextField buildingText = new TextField ();
        buildingText.setPrefHeight(40);
        pane.add(building, 0,0);
        pane.add(buildingText,1,0);

        Label street = new Label("Street name: ");
        TextField streetText = new TextField ();
        streetText.setPrefHeight(40);
        pane.add(street, 0,1);
        pane.add(streetText,1,1);

        Label city = new Label("city: ");
        TextField cityText = new TextField ();
        cityText.setPrefHeight(40);
        pane.add(city, 0,2);
        pane.add(cityText,1,2);

        Label pstlcd = new Label("postal code: ");
        TextField pstlcdText = new TextField ();
        pstlcdText.setPrefHeight(40);
        pane.add(pstlcd, 0,3);
        pane.add(pstlcdText,1,3);

        Button submit =new Button("Add building");
        submit.setOnAction(e->{
            pc.addApartmentBuilding(buildingText.getText(),streetText.getText(),cityText.getText(), pstlcdText.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Apartment building added successfully");
            alert.show();
        });
        pane.add(submit,1,6);


        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,8);
        sceneAddApartmentBuilding=new Scene(pane,800,500);


    }
    void addCondoBuilding()
    {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(0.2);
        pane.setHgap(0.2);
        Label building = new Label("Building name: ");
        TextField buildingText = new TextField ();
        buildingText.setPrefHeight(40);
        pane.add(building, 0,0);
        pane.add(buildingText,1,0);


        Label streetNum = new Label("Street number: ");
        TextField streetNumText = new TextField ();
        streetNumText.setPrefHeight(40);
        pane.add(streetNum, 0,1);
        pane.add(streetNumText,1,1);

        Label street = new Label("Street name: ");
        TextField streetText = new TextField ();
        streetText.setPrefHeight(40);
        pane.add(street, 0,2);
        pane.add(streetText,1,2);

        Label city = new Label("city: ");
        TextField cityText = new TextField ();
        cityText.setPrefHeight(40);
        pane.add(city, 0,3);
        pane.add(cityText,1,3);

        Label pstlcd = new Label("postal code: ");
        TextField pstlcdText = new TextField ();
        pstlcdText.setPrefHeight(40);
        pane.add(pstlcd, 0,4);
        pane.add(pstlcdText,1,4);

        Button submit =new Button("Add Condo Building");
        submit.setOnAction(e->{
            pc.addCondoBuilding(buildingText.getText(),Integer.parseInt(streetNumText.getText()),streetText.getText(),cityText.getText(), pstlcdText.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Condo building added successfully");
            alert.show();
        });
        pane.add(submit,1,6);
        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,8);
        sceneAddCondoBuilding=new Scene(pane,800,500);

    }
    void addApartment()
    {

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(0.2);
        pane.setHgap(0.2);
        Label building = new Label("Building name: ");
        TextField buildingText = new TextField ();
        buildingText.setPrefHeight(40);
        pane.add(building, 0,0);
        pane.add(buildingText,1,0);


        Label rooms = new Label("Number of  Rooms: ");
        TextField roomsText = new TextField ();
        roomsText.setPrefHeight(40);
        pane.add(rooms, 0,1);
        pane.add(roomsText,1,1);

        Label bathrooms = new Label("Number of  bathrooms: ");
        TextField bathroomsText = new TextField ();
        bathroomsText.setPrefHeight(40);
        pane.add(bathrooms, 0,2);
        pane.add(bathroomsText,1,2);

        Label area = new Label("area: ");
        TextField areaText = new TextField ();
        areaText.setPrefHeight(40);
        pane.add(area, 0,3);
        pane.add(areaText,1,3);

        Label rent = new Label("Rent: ");
        TextField rentText = new TextField ();
        rentText.setPrefHeight(40);
        pane.add(rent, 0,4);
        pane.add(rentText,1,4);

        Button submit =new Button("Add Apartment");
        submit.setOnAction(e->{
            pc.addApartment(buildingText.getText(),Integer.parseInt(roomsText.getText()),Integer.parseInt(bathroomsText.getText()),Integer.parseInt(areaText.getText()), Integer.parseInt(rentText.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Apartment  added successfully");
            alert.show();
        });
        pane.add(submit,1,6);

        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,8);
        sceneAddApartment=new Scene(pane,800,500);

    }
    void addCondo()
    {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(0.2);
        pane.setHgap(0.2);
        Label building = new Label("Building name: ");
        TextField buildingText = new TextField ();
        buildingText.setPrefHeight(40);
        pane.add(building, 0,0);
        pane.add(buildingText,1,0);

        Label unit = new Label("Unit Number: ");
        TextField unitText = new TextField ();
        unitText.setPrefHeight(40);
        pane.add(unit, 0,1);
        pane.add(unitText,1,1);

        Label rooms = new Label("Number of  Rooms: ");
        TextField roomsText = new TextField ();
        roomsText.setPrefHeight(40);
        pane.add(rooms, 0,2);
        pane.add(roomsText,1,2);

        Label bathrooms = new Label("Number of  bathrooms: ");
        TextField bathroomsText = new TextField ();
        bathroomsText.setPrefHeight(40);
        pane.add(bathrooms, 0,3);
        pane.add(bathroomsText,1,3);

        Label area = new Label("area: ");
        TextField areaText = new TextField ();
        areaText.setPrefHeight(40);
        pane.add(area, 0,4);
        pane.add(areaText,1,4);

        Label rent = new Label("Rent: ");
        TextField rentText = new TextField ();
        rentText.setPrefHeight(40);
        pane.add(rent, 0,5);
        pane.add(rentText,1,5);

        Button submit =new Button("Add Condo");
        submit.setOnAction(e->{
            pc.addCondo(buildingText.getText(),Integer.parseInt(unitText.getText()),Integer.parseInt(roomsText.getText()),Integer.parseInt(bathroomsText.getText()),Integer.parseInt(areaText.getText()), Integer.parseInt(rentText.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Condo  added successfully");
            alert.show();
        });
        pane.add(submit,1,6);

        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,8);
        sceneAddCondo=new Scene(pane,800,500);
    }
    void addHouse()
    {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(0.2);
        pane.setHgap(0.2);
        Label houseNum = new Label("House num: ");
        TextField houseNumText = new TextField ();
        houseNumText.setPrefHeight(40);
        pane.add(houseNum, 0,0);
        pane.add(houseNumText,1,0);


        Label streetNum = new Label("Street number: ");
        TextField streetNumText = new TextField ();
        streetNumText.setPrefHeight(40);
        pane.add(streetNum, 0,1);
        pane.add(streetNumText,1,1);

        Label street = new Label("Street name: ");
        TextField streetText = new TextField ();
        streetText.setPrefHeight(40);
        pane.add(street, 0,2);
        pane.add(streetText,1,2);

        Label city = new Label("city: ");
        TextField cityText = new TextField ();
        cityText.setPrefHeight(40);
        pane.add(city, 0,3);
        pane.add(cityText,1,3);

        Label pstlcd = new Label("postal code: ");
        TextField pstlcdText = new TextField ();
        pstlcdText.setPrefHeight(40);
        pane.add(pstlcd, 0,4);
        pane.add(pstlcdText,1,4);

        Label rent = new Label("Rent: ");
        TextField rentText = new TextField ();
        rentText.setPrefHeight(40);
        pane.add(rent, 0,5);
        pane.add(rentText,1,5);


        Button submit =new Button("Add House");
        submit.setOnAction(e->{
            pc.addHouse(houseNum.getText(),streetText.getText(),cityText.getText(), pstlcdText.getText(),Integer.parseInt(streetNumText.getText()),Integer.parseInt(rentText.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("House added successfully");
            alert.show();
        });
        pane.add(submit,1,6);

        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,8);

        sceneAddHouse=new Scene(pane,800,500);
    }
    private void createSceneAddProperty()
    {
        StackPane pane=new StackPane();
        Label label=new Label("Please chose the type of property you want to add");
        label.relocate(500,500);
        label.setFont(new Font("Arial",18));
        pane.setMargin(label, new Insets(-180, 140, 80, 100));

        pane.getChildren().add(label);
        RadioButton apartmentBuilding,condoBuilding,apartment,condo,house;
        apartmentBuilding=new RadioButton("Apartment Building");
        apartment=new RadioButton("Apartment");
        condoBuilding=new RadioButton("Condo Building");
        condo=new RadioButton("Condo");
        house=new RadioButton("House");
        ToggleGroup group = new ToggleGroup();
        apartmentBuilding.setToggleGroup(group);
        apartment.setToggleGroup(group);
        condoBuilding.setToggleGroup(group);
        condo.setToggleGroup(group);
        house.setToggleGroup(group);

        pane.setMargin(apartmentBuilding, new Insets(10, 140, 80, 100));
        pane.setMargin(apartment, new Insets(50, 140, 80, 100));
        pane.setMargin(condoBuilding, new Insets(100, 140, 80, 100));
        pane.setMargin(condo, new Insets(150, 140, 80, 100));
        pane.setMargin(house, new Insets(200, 140, 80, 100));
        pane.getChildren().addAll(apartmentBuilding,apartment,condoBuilding,condo,house);


        Button returnHome=new Button("Return to Home screen");
        returnHome.setOnAction(e->window.setScene(scene0));
        pane.setMargin(returnHome, new Insets(300, 140, 80, 100));

        apartmentBuilding.setOnAction(e-> window.setScene(sceneAddApartmentBuilding));
        addApartmentBuilding();

        apartment.setOnAction(e-> window.setScene(sceneAddApartment));
        addApartment();

        condoBuilding.setOnAction(e-> window.setScene(sceneAddCondoBuilding));
        addCondoBuilding();

        condo.setOnAction(e->window.setScene(sceneAddCondo));
        addCondo();

        house.setOnAction(e->window.setScene(sceneAddHouse));
        addHouse();


        pane.getChildren().add(returnHome);

        sceneAddProperty=new Scene(pane,800,500);
    }
    private void createSceneAddTenant()
    {
        GridPane pane = new GridPane();
        Label label=new Label("Please enter tenant details");

        pane.getChildren().add(label);

        Label name = new Label("Name: ");
        TextField nameText = new TextField ();
        nameText.setPrefHeight(40);
        pane.add(name, 0,1);
        pane.add(nameText,1,1);



        Label email = new Label("Email: ");
        TextField emailText = new TextField ();
        emailText.setPrefHeight(40);
        pane.add(email, 0,2);
        pane.add(emailText,1,2);


        Label phone = new Label("Phone number: ");
        TextField phoneText = new TextField ();
        phoneText.setPrefHeight(40);
        pane.add(phone, 0,3);
        pane.add(phoneText,1,3);

        RadioButton apartment,condo,house;
        apartment=new RadioButton("Apartment");
        condo=new RadioButton("Condo");
        house=new RadioButton("House");
        ToggleGroup group = new ToggleGroup();
        apartment.setToggleGroup(group);
        apartment.setSelected(true);
        condo.setToggleGroup(group);
        house.setToggleGroup(group);
        pane.add(apartment,1,4);
        pane.add(condo,1,5);
        pane.add(house,1,6);

        Button choice =new Button("Confirm choice of property");
        choice.setOnAction(e->{

            if (apartment.isSelected()||condo.isSelected())
            {
                Label building = new Label("Building name: ");
                TextField buildingText = new TextField ();
                buildingText.setPrefHeight(40);
                pane.add(building, 0,8);
                pane.add(buildingText,1,8);

                Label unit = new Label("Unit number: ");
                TextField unitText = new TextField ();
                unitText.setPrefHeight(40);
                pane.add(unit, 0,9);
                pane.add(unitText,1,9);Button submit =new Button("Add Tenant");

                submit.setOnAction(f->{
                    String buildingName;
                    int unitNum;
                    unitNum=Integer.parseInt(unitText.getText());
                    buildingName=buildingText.getText();
                    Property property = MockDatabaseController.getProperty(buildingName);
                    Tenant t=new Tenant(nameText.getText(),emailText.getText(),phoneText.getText());

                    if(property instanceof CondoBuilding c)
                    {
                        Condo condo1=null;
                        for(Condo c2 : c.getCondos())
                        {
                            if(c2.getCondoNum() == unitNum)
                            {
                                condo1 = c2;
                                break;
                            }
                        }
                        if (condo1.isAvailable())
                        {
                            lc.addLease(LocalDateTime.now(), LocalDateTime.now().plusYears(1), t, buildingName, condo1.getRent(), unitNum);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText("The condo you are looking is not available!!\n Adding you to the interested tenant list");
                            alert.show();
                            tc.addTenant(buildingName, unitNum, t);
                        }

                    }
                    if(property instanceof ApartmentBuilding a)
                    {
                        Apartment apartment1;
                        apartment1= a.getApartments().get(unitNum-1);

                        if (apartment1.isAvailable())
                        {
                            lc.addLease(LocalDateTime.now(), LocalDateTime.now().plusYears(1), t, buildingName, apartment1.getRent(), unitNum);
                        }
                        else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText("The apartment you are looking is not available!!\n Adding you to the interested tenant list");
                            alert.show();
                            tc.addTenant(buildingName, unitNum, t);
                        }

                    }
                    ArrayList<Tenant> tenants = MockDatabaseController.getAllTenants();
                    for(Tenant tt:tenants)
                    {
                        System.out.println(tt.getInfo());
                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Tenant added successfully");
                    alert.show();
                });
                pane.add(submit,1,13);

            }
            else
            {
                Label houseNum = new Label("House num: ");
                TextField houseNumText = new TextField ();
                houseNumText.setPrefHeight(40);
                pane.add(houseNum, 0,8);
                pane.add(houseNumText,1,8);


                Label streetName = new Label("Street name: ");
                TextField streetNameText = new TextField ();
                streetNameText.setPrefHeight(40);
                pane.add(streetName, 0,9);
                pane.add(streetNameText,1,9);

                Label unit = new Label("Unit number: ");
                TextField unitText = new TextField ();
                unitText.setPrefHeight(40);
                pane.add(unit, 0,10);
                pane.add(unitText,1,10);

                Button submit =new Button("Add Tenant");

                submit.setOnAction(f->{
                    String buildingName;
                    int unitNum;
                    unitNum=Integer.parseInt(unitText.getText());
                    buildingName=houseNum.getText()+" "+streetNameText.getText();
                    Property property = MockDatabaseController.getProperty(buildingName);
                    Tenant t=new Tenant(nameText.getText(),emailText.getText(),phoneText.getText());
                    if(property instanceof House h) {
                        if (h.getAvailable()) {

                            lc.addLease(LocalDateTime.now(), LocalDateTime.now().plusYears(1), t, h.getBuildingName(), h.getRent(), unitNum);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setHeaderText(null);
                            alert.setContentText("The house you are looking is not available!!\n Adding you to the interested tenant list");
                            tc.addTenant(h.getBuildingName(), 0, t);
                        }
                        ArrayList<Tenant> tenants = MockDatabaseController.getAllTenants();
                        for(Tenant tt:tenants)
                        {
                            System.out.println(tt.getInfo());
                        }

                    }
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Tenant added successfully");
                    alert.show();
                });
                pane.add(submit,1,13);


            }

        });
        pane.add(choice,1,7);

        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,15);

        sceneAddTenant=new Scene(pane,800,500);

    }
    private void createSceneDisplayTenant()
    {
        GridPane pane = new GridPane();
        Label label=new Label("Displaying all tenants");

        pane.getChildren().add(label);
        int i=2;
        System.out.println("i"+ tenants.size());
        for(Tenant t:tenants)
        {
            System.out.println("here");
            Text text=new Text();
            text.setText(t.getInfo());
            text.setFont(new Font(18));
            pane.add(text,1,i);
            i++;
        }

        Button back=new Button("Return to Add Property Menu");
        back.setOnAction(e->window.setScene(sceneAddProperty));
        pane.add(back,1,15);

        sceneDisplayTenant=new Scene(pane,800,500);

    }
    private void createSceneDisplayRented()
    {


    }
    private void createSceneDisplayVacant()
    {

    }
    private void createSceneDisplayLease()
    {

    }
    private void createScene0(StackPane stackPane )
    {

        Button addProperty=new Button("Add a property");
        addProperty.setOnAction(e->window.setScene(sceneAddProperty));
        createSceneAddProperty();

        Button addTenant=new Button("Add a Tenant/Rent a Unit");
        addTenant.setOnAction(e->window.setScene(sceneAddTenant));
        createSceneAddTenant();

        Button displayTenant=new Button("Display tenants");
        displayTenant.setOnAction(e->window.setScene(sceneDisplayTenant));
        createSceneDisplayTenant();

        Button displayRentedUnit=new Button("Display Rented units");
        displayRentedUnit.setOnAction(e->window.setScene(sceneDisplayRented));
        createSceneDisplayRented();

        Button displayVacantUnit=new Button("Display Vacant units");
        displayVacantUnit.setOnAction(e->window.setScene(sceneDisplayRented));
        createSceneDisplayVacant();

        Button displayLease=new Button("Display All Leases");
        displayLease.setOnAction(e->window.setScene(sceneDisplayLease));
        createSceneDisplayLease();

        Button exit =new Button("Exit");
        exit.setOnAction(e->window.close());

        StackPane.setMargin(addProperty, new Insets(40, 140, 160, 10));
        StackPane.setMargin(addTenant, new Insets(40, 10, 160, 180));
        StackPane.setMargin(displayTenant, new Insets(80, 140, 120, 10));
        StackPane.setMargin(displayLease, new Insets(80, 5, 120, 180));
        StackPane.setMargin(displayRentedUnit, new Insets(120, 140, 80, 10));
        StackPane.setMargin(displayVacantUnit, new Insets(120, 10, 80, 180));
        StackPane.setMargin(exit, new Insets(160, 140, 40, 10));

        stackPane.getChildren().addAll(addProperty,addTenant,displayTenant,displayLease,displayRentedUnit,displayVacantUnit,exit);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Real Estate Management System");
        StackPane stackPane = new StackPane();
        stackPane.setAlignment(Pos.CENTER);
        primaryStage.setTitle("Property Manager"); // Set the stage title

        scene0 = new Scene(stackPane, 800, 500);
        createScene0(stackPane);
        primaryStage.setScene(scene0); // Place the scene in the stage
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
        window=primaryStage;

        primaryStage.setScene(scene0);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}

