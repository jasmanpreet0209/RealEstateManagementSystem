package Controller;

import Model.*;

public class PropertiesController {


    public void addApartmentBuilding(String building_name, String streetName, String city, String postalCode)
    {
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(building_name,streetName,city,postalCode);
        MockDatabaseController.addProperty(apartmentBuilding);
    }
    public void addApartment(String building_name,int rooms,int baths, int area,int rent) throws Exception {
        ApartmentBuilding a = (ApartmentBuilding) MockDatabaseController.getProperty(building_name);
        if(a!=null)
        {
            a.addApartment(rooms,baths,area,rent);
        }
        else
        {
            System.out.println("The building name you entered does not exist. Enter the building to the properties first");
            throw new Exception("The building name you entered does not exist. Enter the building to the properties first");
        }
    }

    public void addCondoBuilding(String building_name,int street_number,String street_name,String city, String postalCode)
    {
        CondoBuilding condoBuilding = new CondoBuilding(building_name,street_number,street_name,city,postalCode);
        MockDatabaseController.addProperty(condoBuilding);
    }
    public void addCondo(String building_name, int unit,int rooms,int baths, int area,int rent)
    { CondoBuilding condoBuilding = (CondoBuilding) MockDatabaseController.getProperty(building_name);
        if(condoBuilding!=null)
        {
            condoBuilding.addCondo(unit,rooms,baths,area,rent);
        }
        else
        {
            System.out.println("The building name you entered does not exist. Enter the building to the properties first");
        }
    }
    public void addHouse(String houseNumber,String street,String city,String postalCode,int streetNumber,int rent)
    {
        House house = new House(houseNumber,streetNumber,street,city,postalCode,rent);
        MockDatabaseController.addProperty(house);
    }
}
