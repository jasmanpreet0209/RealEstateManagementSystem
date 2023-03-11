package main.Model;

import org.junit.Test;
import org.junit.Before;

public class CondoBuildingTest {
    CondoBuilding building;
@Before
public void before() {
    building =  new CondoBuilding("abc",11,"streetName","city","postalCode");
}
@Test
public void testGetInfo() {
    assert(building.getInfo().contains("abc"));
}
@Test
public void testGetType() {
    assert(building.getType().equals("Condo Building"));
}

@Test
public void testAddCondo()
{
    building.addCondo(4,3,3,500,1000);
    assert(building.getCondos().size()==1);
}
@Test
public void testGetBuildingName() {
    assert(building.getBuildingName().equals("abc"));
}
} 
