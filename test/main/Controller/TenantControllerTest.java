package main.Controller;

import Controller.DatabaseController;
import Controller.TenantController;
import Model.House;
import Model.Property;
import Model.Tenant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class TenantControllerTest {
    TenantController controller;
    Tenant tenant;
    Property property;
@Before
public void before() throws Exception {
    controller = new TenantController();
    tenant = new Tenant("test","test-email","102948783");
    property =  new House("11",11, "test","city","postalcode",600);
}

@Test
public void testAddTenant()  {
    // Test if building info is wrong
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        controller.addTenant("test", 0, tenant);
        db.verify(() -> DatabaseController.getProperty("test"));
    }catch (Exception e) {
        assertEquals(e.getMessage(),"The building name you entered does not exist. Enter the building to the properties first");
    }
}
@Test
public void testAddTenant1() {
    // Test if building info is wrong
    try (MockedStatic<DatabaseController> db = Mockito.mockStatic(DatabaseController.class)) {
        db.when(() -> DatabaseController.getProperty(property.getBuildingName())).thenReturn(property);
        controller.addTenant(property.getBuildingName(),0,tenant);
        db.verify(() -> DatabaseController.getProperty(property.getBuildingName()));
        db.verify(() -> DatabaseController.addTenant(tenant));
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

} 
