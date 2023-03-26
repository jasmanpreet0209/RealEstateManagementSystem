package main.Controller;

import Controller.DatabaseController;
import Controller.PropertiesController;
import Model.ApartmentBuilding;
import Model.CondoBuilding;
import Model.Property;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;

public class PropertiesControllerTest { 

    PropertiesController controller;
    ApartmentBuilding apartmentBuilding;
    CondoBuilding condoBuilding;
    ArrayList<Property> properties;
@Before
public void before() {
    controller = new PropertiesController();
    apartmentBuilding = new ApartmentBuilding("test","test","test","test");
    condoBuilding = new CondoBuilding("condo",1,"test","city","test");
    properties = new ArrayList<>();
    properties.add(apartmentBuilding);
    properties.add(condoBuilding);
} 

@Test
public void testAddApartmentBuilding() {
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        db.when(DatabaseController::getAllProperties).thenReturn(properties);
        controller.addApartmentBuilding("test","streetName","city","postal code");
        db.verify(() -> DatabaseController.addProperty(any()));
    }
}
@Test
public void testAddApartment() throws Exception {
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        db.when(() -> DatabaseController.getProperty("abc")).thenReturn(apartmentBuilding);
        controller.addApartmentBuilding("abc","streetName","city","postal code");
        controller.addApartment("abc",3,4,500,1400);
        db.verify(() -> DatabaseController.addProperty(any()));
        db.verify(() -> DatabaseController.getProperty("abc"));
    }
} 

@Test
public void testAddCondoBuilding() {
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        int sizeBefore = DatabaseController.getAllProperties().size();
        db.when(DatabaseController::getAllProperties).thenReturn(properties);
        controller.addCondoBuilding("test",11,"streetName","city","postal code");
        db.verify(() -> DatabaseController.addProperty(any()));
    }
} 

@Test
public void testAddCondo() {

    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        db.when(() -> DatabaseController.getProperty("condo")).thenReturn(condoBuilding);
        controller.addCondoBuilding("condo", 11, "streetName", "city", "postal code");
        controller.addCondo("condo", 3, 4, 2, 500, 1400);
        db.verify(() -> DatabaseController.addProperty(any()));
        db.verify(() -> DatabaseController.getProperty("condo"));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test
public void testAddHouse() {
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        controller.addHouse("11", "street", "city", "postalCode", 11, 1500);
        db.verify(() -> DatabaseController.addProperty(any()));
    }
}
} 
