package main.Model;

import Model.Tenant;
import org.junit.Before;
import org.junit.Test;

public class TenantTest { 
    Tenant tenant;
@Before
public void before()  {
    tenant = new Tenant("test","test-email","102948783");
} 

@Test
public void testGetName()  { 
    assert (tenant.getName().equals("test"));
} 

@Test
public void testGetInfo()  {
    System.out.println(tenant.getInfo());
    assert (tenant.getInfo().contains("email='test-email'"));
}
}