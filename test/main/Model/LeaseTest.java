package main.Model;

import org.junit.Test;
import org.junit.Before;

import java.time.LocalDateTime;

public class LeaseTest {
    Lease lease;
    Tenant tenant;

@Before
public void before()  {
    tenant = new Tenant("test","test-email","102948783");
    lease = new Lease(tenant, "test", LocalDateTime.now(),LocalDateTime.now().plusMonths(11),1000);
} 

@Test
public void testGetInfo()  {
    System.out.println(lease.getInfo());
    assert (lease.getInfo().contains("name='test'"));
} 

@Test
public void testGetTenant()  { 
    assert (lease.getTenant()==tenant);
} 

@Test
public void testSetPropertyInfo()  {
    assert (!lease.getInfo().contains("newInfo"));
    lease.setPropertyInfo("newInfo");
    assert (lease.getInfo().contains("newInfo"));
}
}