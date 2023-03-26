package Model;

import java.util.ArrayList;

public class ApartmentBuilding extends Property{
    String buildingName;
    public static int numApartments=0;
    private ArrayList<Apartment> apartments;

    public ApartmentBuilding( String buildingName,String streetName, String city, String postalCode){
        super(streetName,city,postalCode);
        apartments = new ArrayList<>();
        this.buildingName =buildingName;
    }
    public void displayApartments()
    {
        for(Apartment apartment : apartments)
        {
            System.out.println(apartment.getInfo());
        }
    }
    // Getters and Setters
    public String getInfo() {
        return "Apartment building (" + numApartments + " apartments) : "
                + buildingName + " "
                + getStreetName()   + " "
                + getCity()         + " "
                + getPostalCode();
    }
    public void addApartment(int numBedrooms, int numBathrooms, int squareFootage,int rent)
    {
        numApartments++;
        Apartment a=new Apartment(numApartments, numBedrooms, numBathrooms, squareFootage,rent);
        apartments.add(a);
    }
    @Override
    public String getType() {
        return "Apartment Building";
    }
    @Override
    public String getBuildingName() {
        return buildingName;
    }
    public int getNumApartments() {return numApartments;}
    public ArrayList<Apartment> getApartments() {return apartments;}

}