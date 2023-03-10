package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Objects;

public class PropertiesController {
    public static ArrayList<Property> properties;

    public PropertiesController() {
        properties = new ArrayList<>();
    }

    public void addApartmentBuilding(String building_name, String streetName, String city, String postalCode)
    {
        ApartmentBuilding apartmentBuilding = new ApartmentBuilding(building_name,streetName,city,postalCode);
        properties.add(apartmentBuilding);
    }
    public void addApartment(String building_name,int rooms,int baths, int area,int rent)
    {
        for(Property p : properties)
        {
            if(p instanceof ApartmentBuilding a)
            {
                if(Objects.equals(a.getBuilding_name(), building_name))
                {
                    a.addApartment(rooms,baths,area,rent);
                    break;
                }
                else
                {
                    System.out.println("The building name you entered does not exist. Enter the building to the properties first");
                }
            }
        }
    }

    public void addCondoBuilding(String building_name,int street_number,String street_name,String city, String postalCode)
    {
        CondoBuilding condoBuilding = new CondoBuilding(building_name,street_number,street_name,city,postalCode);
        properties.add(condoBuilding);
    }
    public void addCondo(String building_name, int unit,int rooms,int baths, int area,int rent)
    {
        for(Property p : properties)
        {
            if(p instanceof CondoBuilding a)
            {
                if(Objects.equals(a.getBuildingName(), building_name))
                {
                    a.add_condo(unit,rooms,baths,area,rent);
                    break;
                }
                else
                {
                    System.out.println("The building name you entered does not exist. Enter the building to the properties first");
                }
            }
        }
    }
    public void addHouse(String houseNumber,String street,String city,String postalCode,int streetNumber,int rent)
    {
        House c = new House(houseNumber,streetNumber,street,city,postalCode,rent);
        properties.add(c);
    }
}
