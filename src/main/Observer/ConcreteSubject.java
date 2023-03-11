package main.Observer;

import main.Controller.MockDatabaseController;
import main.Model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConcreteSubject {
    public void checkLease() {

        ArrayList<Property> properties = MockDatabaseController.getAllProperties();
        for(Property p:properties)
        {
            if(p instanceof ApartmentBuilding building)
            {
                ArrayList<Apartment> apartmentArrayList=building.getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    Lease l=a.getLease();
                    if (l!=null) {
                        if (l.getEndDate().equals(LocalDateTime.now())) {
                            a.notifyTenant();
                        }
                    }
                }

            }
            else if(p instanceof CondoBuilding building)
            {
                ArrayList<Condo> condoArrayList=building.getCondos();
                for (Condo c: condoArrayList)
                {
                    Lease l=c.getLease();
                    if (l!=null) {
                        if (l.getEndDate().equals(LocalDateTime.now())) {
                            c.notifyTenant();
                        }
                    }
                }
            }
            else if (p instanceof House)
            {
                House h= (House) p;
                Lease l=h.getLease();
                if (l!=null) {
                    if (l.getEndDate().equals(LocalDateTime.now())) {
                        h.notifyTenant();
                    }
                }
            }
        }

        }
}
