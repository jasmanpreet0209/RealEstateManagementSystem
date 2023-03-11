package test.Controller;

import main.Controller.MockDatabaseController;
import main.Controller.PropertiesController;
import main.Model.ApartmentBuilding;
import main.Model.CondoBuilding;
import main.Model.Property;
import org.junit.Before;
import org.junit.Test;

public class PropertiesControllerTest { 

    PropertiesController controller;
@Before
public void before() {
    MockDatabaseController.getInstance();
    controller = new PropertiesController();
} 

@Test
public void testAddApartmentBuilding() {
    int sizeBefore = MockDatabaseController.getAllProperties().size();
    controller.addApartmentBuilding("test","streetName","city","postal code");
    assert(MockDatabaseController.getAllProperties().size()==sizeBefore+1);
} 

@Test
public void testAddApartment() {
    controller.addApartmentBuilding("abc","streetName","city","postal code");
    controller.addApartment("abc",3,4,500,1400);
    ApartmentBuilding building = (ApartmentBuilding) MockDatabaseController.getProperty("abc");
    assert(building.getApartments().size()==1);
} 

@Test
public void testAddCondoBuilding() {
    int sizeBefore = MockDatabaseController.getAllProperties().size();
    controller.addCondoBuilding("test",11,"streetName","city","postal code");
    assert(MockDatabaseController.getAllProperties().size()==sizeBefore+1);
} 

@Test
public void testAddCondo() {
    controller.addCondoBuilding("condo",11,"streetName","city","postal code");
    controller.addCondo("condo",3,4,2,500,1400);
    CondoBuilding building = (CondoBuilding) MockDatabaseController.getProperty("condo");
    assert(building.getCondos().size()==1);
}

@Test
public void testAddHouse() {
    int sizeBefore = MockDatabaseController.getAllProperties().size();
    controller.addHouse("11","street","city","postalCode",11,1500);
    assert(MockDatabaseController.getAllProperties().size()==sizeBefore+1);
}
} 
