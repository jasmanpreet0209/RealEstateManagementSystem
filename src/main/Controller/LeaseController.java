package main.Controller;

import main.Model.*;

import java.time.LocalDateTime;

public class LeaseController {
    public void addLease(LocalDateTime startDate, LocalDateTime endDate, Tenant tenant,String info, int rent,int unit)
    {
        Property p = MockDatabaseController.getProperty(info);
        if(p==null)
        {
            System.out.println("The building name you entered does not exist. Enter the building to the properties first");
            return;
        }
        Lease l = new Lease(tenant,p.getInfo(),startDate,endDate,rent);
        if(p instanceof CondoBuilding building)
        {
            Condo condo = null;
            for(Condo c : building.getCondos())
            {
                if(c.getCondoNum() == unit)
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
            l.setPropertyInfo(condo.getInfo() + "\n" + building.getInfo()+ "\n");
            condo.setLease(l);
            condo.addTenants(tenant);
            condo.setAvailable(false);
        }
        else if(p instanceof ApartmentBuilding building)
        {
            if(unit > building.getNumApartments())
            {
                System.out.println("Enter valid unit number");
                return;
            }
            Apartment apartment= building.getApartments().get(unit-1);
            l.setPropertyInfo(apartment.getInfo() + "\n" + building.getInfo()+ "\n");
            apartment.setLease(l);
            apartment.addTenant(tenant);
            apartment.setAvailable(false);
        }
        else if(p instanceof House h)
        {
            h.setLease(l);
            h.addTenants(tenant);
            h.setAvailable(false);
        }
        MockDatabaseController.addLease(l);
        MockDatabaseController.addTenant(tenant);
    }
}
