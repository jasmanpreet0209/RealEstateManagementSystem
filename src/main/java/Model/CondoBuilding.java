package Model;

import java.util.ArrayList;

public class CondoBuilding extends Property{
    int streetNum;
    String buildingName;
    public static int numCondos =0;
    private ArrayList<Condo> condos;

    public CondoBuilding(String buildingName,int streetNum,String streetName, String city, String postalCode){
        super(streetName,city,postalCode);
        condos = new ArrayList<>();
        this.streetNum =streetNum;
        this.buildingName =buildingName;
    }
    public void addCondo(int UnitNum, int numBedrooms, int numBathrooms, int squareFootage, int rent)
    {
        numCondos++;
        Condo a=new Condo(UnitNum, numBedrooms, numBathrooms, squareFootage,rent);
        condos.add(a);
    }
    @Override
    public String getInfo() {
        return "Condo building (" + numCondos + " condos) : "+ buildingName + " " + streetNum + " " + getStreetName()
                +" " +getCity()+" "+getPostalCode();
    }
    public void displayCondos()
    {
        for(Condo condo : condos)
        {
            System.out.println(condo.getInfo());
        }
    }
    @Override
    public String getType() {
        return "Condo Building";
    }
    public ArrayList<Condo> getCondos() {
        return condos;
    }
    @Override
    public String getBuildingName() {
        return buildingName;
    }
}