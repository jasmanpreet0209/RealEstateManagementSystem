package main.Controller;

import Controller.LeaseController;
import Controller.DatabaseController;
import Model.House;
import Model.Property;
import Model.Tenant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class LeaseControllerTest { 
    LeaseController controller;
    Tenant tenant;
    Property property;
@Before
public void before() {
    controller = new LeaseController();
    tenant = new Tenant("test","test-email","102948783");
    property =  new House("11",11, "test","city","postalcode",600);
}

@Test
public void testAddLease_fail() {
    // Testing if wrong building info is passed
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        controller.addLease(LocalDateTime.now(), LocalDateTime.now().plusMonths(11), tenant, "test", 500, 0);
        db.verify(() -> DatabaseController.getProperty("test"));
    }
    catch (Exception e) {
        assertEquals(e.getMessage(),"The building name you entered does not exist. Enter the building to the properties first");
    }
}
@Test
public void testAddLease() {
    // Test add lease for house
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        db.when(() -> DatabaseController.getProperty(property.getBuildingName())).thenReturn(property);
        controller.addLease(LocalDateTime.now(), LocalDateTime.now().plusMonths(11), tenant, property.getBuildingName(), 500, 0);
        db.verify(() -> DatabaseController.getProperty( property.getBuildingName()));
        db.verify(()-> DatabaseController.addLease(any()));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

} 
