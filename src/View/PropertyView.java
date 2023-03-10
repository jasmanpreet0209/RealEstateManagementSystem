package View;

import Controller.PropertiesController;
import Model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import static Controller.PropertiesController.properties;
import static Controller.LeaseController.leases;
public class PropertyView {
    PropertiesController pc;
    public PropertyView() {
        this.pc = new PropertiesController();

    }

    void addProperty()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter details of the property:");
        int property_type;
        do {
            System.out.println("Please select the property type:\n 1.Apartment building\n2. Apartment\n 3.condo building" +
                    "\n 4.condo\n5.House\n6.Exit");
            property_type = Integer.parseInt(sc.nextLine());
            switch (property_type) {
                case 1: {
                    System.out.println("Enter building name");
                    String building_name=sc.nextLine();
                    System.out.println("Enter street name");
                    String streetName=sc.nextLine();
                    System.out.println("Enter city ");
                    String city=sc.nextLine();
                    System.out.println("Enter pstl cd");
                    String postalCode=sc.nextLine();
                    pc.addApartmentBuilding( building_name,  streetName,  city,  postalCode);
                    break;
                }
                case 2: {
                    System.out.println("Enter building name");
                    String building_name=sc.nextLine();
                    System.out.println("Enter aptNum");
                    String aptNumber=sc.nextLine();
                    System.out.println("Enter num of Rooms ");
                    int rooms=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter num of bathrooms ");
                    int baths=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter area ");
                    int area=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Rent ");
                    int rent=Integer.parseInt(sc.nextLine());
                    pc.addApartment( building_name, aptNumber, rooms, baths,  area, rent);
                    break;
                }
                case 3: {
                    System.out.println("Enter building name");
                    String building_name=sc.nextLine();
                    System.out.println("Enter street num ");
                    int street_number=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter street name");
                    String streetName=sc.nextLine();
                    System.out.println("Enter city ");
                    String city=sc.nextLine();
                    System.out.println("Enter pstl cd");
                    String postalCode=sc.nextLine();
                    pc.addCondoBuilding( building_name,  street_number,streetName,  city,  postalCode);

                    break;
                }
                case 4: {
                    System.out.println("Enter building name");
                    String building_name=sc.nextLine();
                    System.out.println("Enter unit number");
                    int unit=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter num of Rooms ");
                    int rooms=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter num of bathrooms ");
                    int baths=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter area ");
                    int area=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Rent ");
                    int rent=Integer.parseInt(sc.nextLine());
                    pc.addCondo( building_name, unit, rooms, baths,  area, rent);

                    break;
                }
                case 5: {

                    System.out.println("Enter street num ");
                    int street_number=Integer.parseInt(sc.nextLine());
                    System.out.println("Enter street name");
                    String street=sc.nextLine();
                    System.out.println("Enter city ");
                    String city=sc.nextLine();
                    System.out.println("Enter pstl cd");
                    String postalCode=sc.nextLine();
                    System.out.println("Enter house number");
                    String houseNumber=sc.nextLine();
                    pc.addHouse( houseNumber, street, city, postalCode, street_number);
                    break;

                } case 6:
                    break;
                default:
                    System.out.println("please select again");
            }
        } while (property_type!=6);

    }
    void displayProperties()
    {
        for(Property p : properties)
        {
            System.out.println(p.getInfo();)
        }
    }
    void displayRentedUnits()
    {
        for(Property p : properties)
        {
            if(p instanceof ApartmentBuilding)
            {
                ArrayList<Apartment> apartmentArrayList=((ApartmentBuilding) p).getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    if (!a.isAvailable())
                    {
                        System.out.println(p.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else if(p instanceof CondoBuilding)
            {
                ArrayList<Condo> condoArrayList=((CondoBuilding) p).getCondos();
                for (Condo a: condoArrayList)
                {
                    if (!a.isAvailable())
                    {
                        System.out.println(p.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else
            {
                House h= (House) p;
                if (h.getAvailable()==false)
                {
                    System.out.println(p.getBuildingName());
                    System.out.println(h.getInfo());
                }


            }
        }
    }
    void displayVacantUnits()
    {
        for(Property p : properties)
        {
            if(p instanceof ApartmentBuilding)
            {
                ArrayList<Apartment> apartmentArrayList=((ApartmentBuilding) p).getApartments();
                for (Apartment a: apartmentArrayList)
                {
                    if (a.isAvailable())
                    {
                        System.out.println(p.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else if(p instanceof CondoBuilding)
            {
                ArrayList<Condo> condoArrayList=((CondoBuilding) p).getCondos();
                for (Condo a: condoArrayList)
                {
                    if (!a.isAvailable())
                    {
                        System.out.println(p.getBuildingName());
                        System.out.println(a.getInfo());
                    }
                }

            }
            else
            {
                House h= (House) p;
                if (h.getAvailable()==true)
                {
                    System.out.println(p.getBuildingName());
                    System.out.println(h.getInfo());
                }


            }
        }
    }
}
