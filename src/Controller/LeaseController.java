package Controller;

import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static Controller.PropertiesController.properties;

public class LeaseController {
    public static ArrayList<Lease> leases;

    public LeaseController() {
        this.leases = new ArrayList<>();
    }
    public void addLease(LocalDate startDate, LocalDate endDate, Tenant tenant,String info, int rent,int unit)
    {
        Lease l = new Lease(tenant,info,startDate,endDate,rent);
        for(Property p : properties)
        {
            if(p.getInfo().equals(info))
            {
                if(p instanceof CondoBuilding c)
                {
                    Condo condo= c.getCondos().get(unit);
                    condo.add_lease(l);
                }
                else if(p instanceof ApartmentBuilding a)
                {
                    Apartment apartment= a.getApartments().get(unit);
                    apartment.add_lease(l);
                }
                else
                {
                    House h = (House) p;
                    h.add_lease(l);
                }
            }
        }
        leases.add(l);
    }
}
