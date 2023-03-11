package test.Controller;

import main.Controller.MockDatabaseController;
import main.Controller.TenantController;
import main.Model.House;
import main.Model.Property;
import main.Model.Tenant;
import org.junit.Before;
import org.junit.Test;

public class TenantControllerTest {
    TenantController controller;
    Tenant tenant;
    Property property;
@Before
public void before() throws Exception {
    MockDatabaseController.getInstance();
    controller = new TenantController();
    tenant = new Tenant("test","test-email","102948783");
    property =  new House("11",11,"test","city","postalcode",600);
    MockDatabaseController.addProperty(property);
}

@Test
public void testAddTenant() {
    // Test if building info is wrong
    int sizeBefore = MockDatabaseController.getAllTenants().size();
    controller.addTenant("test",0,tenant);
    assert(MockDatabaseController.getAllTenants().size()==sizeBefore);
}
@Test
public void testAddTenant1() {
    // Test if building info is wrong
    int sizeBefore = MockDatabaseController.getAllTenants().size();
    controller.addTenant(property.getBuildingName(),0,tenant);
    assert(MockDatabaseController.getAllTenants().size()==sizeBefore+1);
}

} 
