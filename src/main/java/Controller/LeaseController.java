package Controller;

import Model.*;

import java.time.LocalDateTime;

public class LeaseController {
    public void addLease(LocalDateTime startDate, LocalDateTime endDate, Tenant tenant,String info, int rent,int unit) throws Exception {
        Property p = DatabaseController.getProperty(info);
        if(p==null)
        {
            System.out.println("The building name you entered does not exist. Enter the building to the properties first");
            throw new Exception("The building name you entered does not exist. Enter the building to the properties first");
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
                throw new Exception("There is no condo unit :" + unit + " available!! Enter valid condo unit\n");
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
                throw new Exception("Enter valid unit number");
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
        DatabaseController.addLease(l);
        DatabaseController.addTenant(tenant);
    }
}
