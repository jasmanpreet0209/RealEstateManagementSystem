package main.Controller;

import main.Model.*;

public class TenantController {

    public void addTenant(String info, int unit, Tenant tenant)
    {
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
            condo.addPotentialTenants(tenant);
        }
        else if(p instanceof ApartmentBuilding a)
        {
            Apartment apartment= a.getApartments().get(unit);
            apartment.addPotentialTenants(tenant);
        }
        else if(p instanceof House)
        {
            House house = (House) p;
            assert house != null;
            house.addPotentialTenants(tenant);
        }
        MockDatabaseController.addTenant(tenant);
    }
}
