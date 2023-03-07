package Model;

import java.util.ArrayList;


public class ApartmentBuilding extends Property{
    public static int num_apartments=0;
    String building_name;
    private ArrayList<Apartment> apartments;

    public ApartmentBuilding( String building_name,String streetName, String city, String postalCode){
        super(streetName,city,postalCode);
        apartments = new ArrayList<>();
        this.building_name=building_name;
    }
    public void addApartment(String apartment_num, int numBedrooms, int numBathrooms, int squareFootage,int rent)
    {
        num_apartments++;
        Apartment a=new Apartment(apartment_num, numBedrooms, numBathrooms, squareFootage,rent);
        apartments.add(a);
    }

    public void DisplayApartments()
    {
        for (int i=0;i<apartments.size();i++)
        {
            System.out.println(apartments.get(i));
        }
    }

    public String getBuilding_name() {
        return building_name;
    }

    @Override
    public String getType() {
        return "Apartment Building";
    }

    public ArrayList<Apartment> getApartments() {
        return apartments;
    }

    @Override
    public String getInfo() {
        return "Apartment building (" + num_apartments + " apartments) : " + building_name + " " + getStreetName()
                +" " +getCity()+" "+getPostalCode();
    }
}