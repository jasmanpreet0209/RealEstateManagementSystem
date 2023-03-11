package main.View;

import main.Controller.MockDatabaseController;
import main.Controller.PropertiesController;
import main.Model.*;

import java.util.ArrayList;
import java.util.Scanner;
public class PropertyView {
    PropertiesController pc;
    Scanner sc = new Scanner(System.in);
    public PropertyView() {
        this.pc = new PropertiesController();

    }

    void addProperty()
    {
        System.out.println("Enter details of the property:");
        int property_type=0;
        do {

            System.out.println("""
                    Please select the property type:
                    1.Apartment building
                    2.Apartment
                    3.condo building
                    4.condo
                    5.House
                    6.Exit""");
            try {
                property_type = Integer.parseInt(sc.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("You entered an invalid option! Please try again!");
                property_type=6;
            }
            switch (property_type) {
                case 1: {
                    try
                    {
                        System.out.println("Enter building name");
                        String building_name=sc.nextLine();
                        System.out.println("Enter street name");
                        String streetName=sc.nextLine();
                        System.out.println("Enter city ");
                        String city=sc.nextLine();
                        System.out.println("Enter pstl cd");
                        String postalCode=sc.nextLine();
                        pc.addApartmentBuilding( building_name,  streetName,  city,  postalCode);
                    }
                    catch (Exception e)
                    {
                        System.out.println("You entered an invalid option, Please try again!");
                        addProperty();
                    }

                    break;
                }
                case 2: {
                    try
                    {
                        System.out.println("Enter building name");
                        String building_name = sc.nextLine();
                        System.out.println("Enter num of Rooms ");
                        int rooms = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter num of bathrooms ");
                        int baths = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter area ");
                        int area = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Rent ");
                        int rent = Integer.parseInt(sc.nextLine());
                        pc.addApartment(building_name, rooms, baths, area, rent);
                    }
                    catch (Exception e)
                    {
                        System.out.println("You entered an invalid option, Please try again!");
                        addProperty();
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Enter building name");
                        String building_name = sc.nextLine();
                        System.out.println("Enter street num ");
                        int street_number = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter street name");
                        String streetName = sc.nextLine();
                        System.out.println("Enter city ");
                        String city = sc.nextLine();
                        System.out.println("Enter pstl cd");
                        String postalCode = sc.nextLine();
                        pc.addCondoBuilding(building_name, street_number, streetName, city, postalCode);
                    }
                    catch (Exception e)
                    {
                        System.out.println("You entered an invalid option, Please try again!");
                        addProperty();
                    }
                    break;
                }
                case 4: {
                    try
                    {
                        System.out.println("Enter building name");
                        String building_name = sc.nextLine();
                        System.out.println("Enter unit number");
                        int unit = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter num of Rooms ");
                        int rooms = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter num of bathrooms ");
                        int baths = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter area ");
                        int area = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter Rent ");
                        int rent = Integer.parseInt(sc.nextLine());
                        pc.addCondo(building_name, unit, rooms, baths, area, rent);
                    }
                    catch (Exception e)
                    {
                        System.out.println("You entered an invalid option, Please try again!");
                        addProperty();
                    }
                    break;
                }
                case 5: {
                    try
                    {
                        System.out.println("Enter street num ");
                        int street_number = Integer.parseInt(sc.nextLine());
                        System.out.println("Enter street name");
                        String street = sc.nextLine();
                        System.out.println("Enter city ");
                        String city = sc.nextLine();
                        System.out.println("Enter pstl cd");
                        String postalCode = sc.nextLine();
                        System.out.println("Enter house number");
                        String houseNumber = sc.nextLine();
                        System.out.println("Enter Rent ");
                        int rent = Integer.parseInt(sc.nextLine());
                        pc.addHouse(houseNumber, street, city, postalCode, street_number, rent);
                    }
                    catch (Exception e)
                    {
                        System.out.println("You entered an invalid option, Please try again!");
                        addProperty();
                    }
                    break;

                } case 6: {
                    property_type=6;
                    break;
                }
                default:
                    System.out.println("please select again");
            }
        } while (property_type!=6);

    }
    void displayProperties()
    {
        ArrayList<Property> properties = MockDatabaseController.getAllProperties();
        for(Property p : properties)
        {
            System.out.println("Building: "+ p.getBuildingName());
            System.out.println(p.getInfo());
        }
    }
    void displayRentedUnits()
    {
        ArrayList<Property> properties = MockDatabaseController.getAllProperties();
        for(Property p : properties)
        {
            if(p instanceof ApartmentBuilding building)
            {
                ArrayList<Apartment> apartmentArrayList=building.getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    if (!a.isAvailable())
                    {
                        System.out.println("Apartment Building: "+building.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else if(p instanceof CondoBuilding building)
            {
                ArrayList<Condo> condoArrayList=building.getCondos();
                for (Condo a: condoArrayList)
                {
                    if (!a.isAvailable())
                    {
                        System.out.println("Condo Building: "+building.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }
            }
            else
            {
                House h= (House) p;
                if (!h.getAvailable())
                {
                    System.out.println("House: "+h.getBuildingName());
                    System.out.println(h.getInfo());
                }
            }
        }
    }
    void displayVacantUnits()
    {
        ArrayList<Property> properties = MockDatabaseController.getAllProperties();
        for(Property p : properties)
        {
            if(p instanceof ApartmentBuilding building)
            {
                ArrayList<Apartment> apartmentArrayList=building.getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    if (a.isAvailable())
                    {
                        System.out.println(building.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else if(p instanceof CondoBuilding building)
            {
                ArrayList<Condo> condoArrayList=building.getCondos();
                for (Condo c: condoArrayList)
                {
                    if (c.isAvailable())
                    {
                        System.out.println(building.getBuildingName());
                        System.out.println(c.getInfo());
                    }
                }
            }
            else if (p instanceof House)
            {
                House h= (House) p;
                if (h.getAvailable())
                {
                    System.out.println(h.getBuildingName());
                    System.out.println(h.getInfo());
                }
            }
        }
    }
}
