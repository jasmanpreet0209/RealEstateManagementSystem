package main.Model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class HouseTest { 
    House house;
    Lease lease;
    Tenant tenant;
@Before
public void before()  {
    house = new House("11",12,"streetName","city","postalCode",2000);
    tenant = new Tenant("test","test-email","102948783");
    lease = new Lease(tenant, "test", LocalDateTime.now(),LocalDateTime.now().plusMonths(11),1000);
}

@Test
public void testGetInfo()  { 
    assert(house.getInfo().contains("Monthly rent 2000"));
} 

@Test
public void testGetRent()  { 
    assert (house.getRent()==2000);
} 

@Test
public void testSetLease()  {
    house.setLease(lease);
    assert (house.getLease()==lease);
} 

@Test
public void testGetType()  { 
    assert (house.getType().equals("House"));
} 

@Test
public void testGetAvailable()  { 
    assert (house.getAvailable());
} 

@Test
public void testAddTenants()  { 
    house.addTenants(tenant);
    assert (house.getTenant()==tenant);
} 

@Test
public void testGetBuildingName()  { 
    assert (house.getBuildingName().equals("11 streetName"));
} 

@Test
public void testAddPotentialTenants()  { 
    house.addPotentialTenants(tenant);
    assert (house.getPotentialTenants().get(0)==tenant);
}
}