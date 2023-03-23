package main.Model;

import Model.Condo;
import Model.Lease;
import Model.Tenant;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class CondoTest { 
    Condo condo;
    Lease lease;
    Tenant tenant;
@Before
public void before()  {
    condo = new Condo(4,3,3,500,1000);
    tenant = new Tenant("test","test-email","102948783");
    lease = new Lease(tenant, "test", LocalDateTime.now(),LocalDateTime.now().plusMonths(11),1000);
}
@Test
public void testGetInfo()  { 
    assert(condo.getInfo().contains("rent=1000"));
} 

@Test
public void testGetRent()  { 
    assert(condo.getRent()==1000);
} 

@Test
public void testSetLease()  {
    condo.setLease(lease);
    assert(condo.getLease()==lease);
} 

@Test
public void testGetTenant()  {
    condo.addTenants(tenant);
    assert(condo.getTenant()==tenant);
} 

@Test
public void testGetCondoNum()  { 
    assert (condo.getCondoNum()==4);
} 

@Test
public void testIsAvailable()  { 
    assert (condo.isAvailable());
} 

@Test
public void testAddPotentialTenants()  { 
    condo.addPotentialTenants(tenant);
    assert(condo.getPotentialTenant().get(0)==tenant);
}
} 
