package main.Observer;

import main.Controller.MockDatabaseController;
import main.Model.*;

import java.time.LocalDate;
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
                        if (l.getEndDate().equals(LocalDate.now())) {
                            a.notify_tenant();
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
                        if (l.getEndDate() == LocalDate.now()) {
                            c.notify_tenant();
                        }
                    }
                }
            }
            else if (p instanceof House)
            {
                House h= (House) p;
                Lease l=h.getLease();
                if (l!=null) {
                    if (l.getEndDate() == LocalDate.now()) {
                        h.notify_tenant();
                    }
                }
            }
        }

        }
}