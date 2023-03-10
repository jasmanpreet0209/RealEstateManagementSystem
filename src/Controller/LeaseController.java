package Controller;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static Controller.PropertiesController.properties;
import static Controller.TenantController.tenants;

public class LeaseController {
    public static ArrayList<Lease> leases;

    public LeaseController() {
        leases = new ArrayList<>();
    }
    public void addLease(LocalDate startDate, LocalDate endDate, Tenant tenant,String info, int rent,int unit)
    {
        tenants.add(tenant);
        Lease l = new Lease(tenant,info,startDate,endDate,rent);
        for(Property p : properties)
        {
            if(p.getInfo().equals(info))
            {
                if(p instanceof CondoBuilding c)
                {
                    Condo condo= c.getCondos().get(unit);
                    condo.add_lease(l);
                    condo.addTenants(tenant);
                    condo.setAvailable(false);
                }
                else if(p instanceof ApartmentBuilding a)
                {
                    Apartment apartment= a.getApartments().get(unit);
                    apartment.add_lease(l);
                    apartment.addTenants(tenant);
                    apartment.setAvailable(false);
                }
                else
                {
                    House h = (House) p;
                    h.add_lease(l);
                    h.addTenants(tenant);
                    h.setAvailable(false);
                }
            }
        }
        leases.add(l);
    }
}
