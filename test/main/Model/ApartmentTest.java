package main.Model;

import Model.Apartment;
import Model.Lease;
import Model.Tenant;
import org.junit.Before;
import org.junit.Test;

public class ApartmentTest { 
    Apartment apartment;
    Tenant tenant;
@Before
public void before() {

    tenant = new Tenant("test","test-email","102948783");
    apartment = new Apartment(1,2,2,400,1000);
} 

@Test
public void testGetInfo() {
    String info = apartment.getInfo();
    assert(info.contains("squareFootage=400"));
} 

@Test
public void testGetRent() throws Exception { 
    int rent = apartment.getRent();
    assert(rent==1000);
} 

@Test
public void testGetLease() {
    Lease lease =  apartment.getLease();
    assert(lease==null);
} 

@Test
public void testGetTenant() {
    apartment.addTenant(tenant);
    assert(apartment.getTenant()==tenant);
} 

@Test
public void testIsAvailable() {
    assert(apartment.isAvailable());
    apartment.setAvailable(false);
    assert(!apartment.isAvailable());
} 

@Test
public void testAddPotentialTenants() {
    apartment.addPotentialTenants(tenant);
    assert(apartment.getPotentialTenant().get(0)==tenant);
}
} 
