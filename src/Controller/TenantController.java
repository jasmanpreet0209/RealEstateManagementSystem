package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;

import static Controller.PropertiesController.properties;

public class TenantController {
    public static ArrayList<Tenant> tenants;

    public TenantController() {
        tenants = new ArrayList<>();
    }

    public void addTenant(String info, int unit, Tenant tenant)
    {
        tenants.add(tenant);
        for(Property p : properties)
        {
            if(p.getInfo().equals(info))
            {
                if(p instanceof CondoBuilding c)
                {
                    Condo condo= c.getCondos().get(unit);
                    condo.addPotentialTenants(tenant);
                }
                else if(p instanceof ApartmentBuilding a)
                {
                    Apartment apartment= a.getApartments().get(unit);
                    apartment.addPotentialTenants(tenant);
                }
                else
                {
                    House h = (House) p;
                    h.addPotentialTenants(tenant);
                }
            }
        }
    }
}
