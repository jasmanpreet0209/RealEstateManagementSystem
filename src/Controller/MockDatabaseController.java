package Controller;

import Model.ApartmentBuilding;
import Model.Lease;
import Model.Property;
import Model.Tenant;

import java.util.ArrayList;
import java.util.Objects;

public class MockDatabaseController {
    public static ArrayList<Property> properties;
    public static ArrayList<Lease> leases;
    public static ArrayList<Tenant> tenants;

    public static ArrayList<Property> getAllProperties()
    {
        return properties;
    }

    public static Property getProperty(String key)
    {
        for(Property p : properties)
        {
            if(Objects.equals(p.getBuildingName(), key))
                    return p;
        }
        return null;
    }
    public static void addProperty(Property property)
    {
        properties.add(property);
    }
    public static ArrayList<Tenant> getAllTenants()
    {
        return tenants;
    }

    public static void addTenant(Tenant tenant) {
        tenants.add(tenant);
    }

    public static ArrayList<Lease> getAllLeases()
    {
        return leases;
    }
    public static void addLease(Lease l) {
        leases.add(l);
    }
}
