package test.main.Model;

import main.Model.ApartmentBuilding;
import org.junit.Before;
import org.junit.Test;

public class ApartmentBuildingTest { 
    ApartmentBuilding building;
@Before
public void before() {
    building =new ApartmentBuilding("abc","streetName","city","postalCode");
} 

@Test
public void testGetInfo() { 
    assert(building.getInfo().contains("abc"));
} 

@Test
public void testAddApartment() {
    int countBefore = building.getNumApartments();
    building.addApartment(1,2,200,400);
    assert(building.getNumApartments()==countBefore+1);
} 
 
@Test
public void testGetType() {
    assert(building.getType().equals("Apartment Building"));
} 

@Test
public void testGetBuildingName() { 
    assert(building.getBuildingName().equals("abc"));
}
} 
