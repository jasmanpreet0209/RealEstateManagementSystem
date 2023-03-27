package ObserverPattern;

import Controller.DatabaseController;
import Model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ConcreteSubject {
    public void checkLease() {
        ArrayList<Property> properties = DatabaseController.getAllProperties();
        for(Property p:properties)
        {
            if(p instanceof ApartmentBuilding building)
            {
                ArrayList<Apartment> apartmentArrayList=building.getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    Lease l=a.getLease();
                    if (l!=null) {
                        if (l.getEndDate().isBefore(LocalDateTime.now())) {
                            String message = a.notifyTenant();
                            System.out.println(message);
                            //Todo call createScene with msg
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
                            String message = c.notifyTenant();
                            System.out.println(message);
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
                        String message = h.notifyTenant();
                        System.out.println(message);
                    }
                }
            }
        }

        }
}
