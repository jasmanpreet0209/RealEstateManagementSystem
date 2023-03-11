package test.Controller; 

import main.Controller.LeaseController;
import main.Controller.MockDatabaseController;
import main.Model.House;
import main.Model.Property;
import main.Model.Tenant;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDate;

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

/** 
* 
* Method: addLease(LocalDate startDate, LocalDate endDate, Tenant tenant, String info, int rent, int unit) 
* 
*/ 
@Test
public void testAddLease_fail() {
    // Testing if wrong building info is passed
    controller.addLease(LocalDate.now(),LocalDate.now().plusMonths(11),tenant,"test",500,0);
    assert(MockDatabaseController.getAllLeases().size()==0);
}
@Test
public void testAddLease() {
    // Testing if right building info is passed
    controller.addLease(LocalDate.now(),LocalDate.now().plusMonths(11),tenant,"11 test",500,0);
    assert(MockDatabaseController.getAllLeases().size()==1);
}

} 
