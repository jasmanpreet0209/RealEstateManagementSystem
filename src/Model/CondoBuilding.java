package Model;

import java.util.ArrayList;

public class CondoBuilding extends Property{
    public static int num_condos=0;
    int Street_num;
    String building_name;
    private ArrayList<Condo> condos;

    public CondoBuilding(String building_name,int Street_Num,String streetName, String city, String postalCode){
        super(streetName,city,postalCode);
        condos = new ArrayList<>();
        this.Street_num=Street_Num;
        this.building_name=building_name;
    }
    public void add_condo(int UnitNum, int numBedrooms, int numBathrooms, int squareFootage,int rent)
    {
        num_condos++;
        Condo a=new Condo(UnitNum, numBedrooms, numBathrooms, squareFootage,rent);
        condos.add(a);
    }

    public void DisplayApartments()
    {
        for (int i=0;i<condos.size();i++)
        {
            System.out.println(condos.get(i));
        }
    }

    public int getStreet_num() {
        return Street_num;
    }
    @Override
    public String getType() {
        return "Condo Building";
    }
    @Override
    public String getInfo() {
        return "Condo building (" + num_condos + " condos) : " + Street_num + " " + getStreetName()
                +" " +getCity()+" "+getPostalCode();
    }

    public ArrayList<Condo> getCondos() {
        return condos;
    }

    @Override
    public String getBuildingName() {
        return building_name;
    }
}