package test.main.Controller;

import main.Controller.LeaseController;
import main.Controller.MockDatabaseController;
import main.Model.House;
import main.Model.Property;
import main.Model.Tenant;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class LeaseControllerTest { 
    LeaseController controller;
    Tenant tenant;
    Property property;
@Before
public void before() {
    MockDatabaseController.getInstance();
    controller = new LeaseController();
    tenant = new Tenant("test","test-email","102948783");
    property =  new House("11",11,"test","city","postalcode",600);
    MockDatabaseController.addProperty(property);
}

@Test
public void testAddLease_fail() {
    // Testing if wrong building info is passed
    int countBefore = MockDatabaseController.getAllLeases().size();
    controller.addLease(LocalDateTime.now(),LocalDateTime.now().plusMonths(11),tenant,"test",500,0);
    assert(MockDatabaseController.getAllLeases().size()==countBefore);
}
@Test
public void testAddLease() {
    // Test add lease for house
    int countBefore = MockDatabaseController.getAllLeases().size();
    controller.addLease(LocalDateTime.now(),LocalDateTime.now().plusMonths(11),tenant, property.getBuildingName(), 500,0);
    assert(MockDatabaseController.getAllLeases().size()==countBefore+1);
}

} 
