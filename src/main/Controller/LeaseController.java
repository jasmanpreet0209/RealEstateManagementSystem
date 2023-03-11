package main.Controller;

import main.Model.*;

import java.time.LocalDate;

public class LeaseController {
    public void addLease(LocalDate startDate, LocalDate endDate, Tenant tenant,String info, int rent,int unit)
    {
        MockDatabaseController.addTenant(tenant);
        Lease l = new Lease(tenant,info,startDate,endDate,rent);
        Property p = MockDatabaseController.getProperty(info);
        if(p==null)
        {
            System.out.println("The building name you entered does not exist. Enter the building to the properties first");
            return;
        }
        if(p instanceof CondoBuilding building)
        {
            Condo condo = null;
            for(Condo c : building.getCondos())
            {
                if(c.getCondo_num() == unit)
                {
                    condo = c;
                    break;
                }
            }
            if(condo==null)
            {
                System.out.println("There is no condo unit :" + unit + " available!! Enter valid condo unit\n");
                return;
            }
            condo.add_lease(l);
            condo.addTenants(tenant);
            condo.setAvailable(false);
        }
        else if(p instanceof ApartmentBuilding a)
        {
            Apartment apartment= a.getApartments().get(unit-1);
            apartment.add_lease(l);
            apartment.addTenant(tenant);
            apartment.setAvailable(false);
        }
        else if(p instanceof House)
        {
            House h = (House) p;
            assert h != null;
            h.add_lease(l);
            h.addTenants(tenant);
            h.setAvailable(false);
        }
        MockDatabaseController.addLease(l);
    }
}
