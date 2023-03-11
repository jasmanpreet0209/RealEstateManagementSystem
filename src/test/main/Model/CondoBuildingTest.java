package test.main.Model; 

import main.Model.CondoBuilding;
import org.junit.Test;
import org.junit.Before;

/** 
* Condo Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar. 11, 2023</pre> 
* @version 1.0 
*/ 
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
