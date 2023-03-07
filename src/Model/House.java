package Model;

import Model.Address;

import java.time.LocalDate;
import java.util.ArrayList;

public class House extends Address implements Property{

    private int StreetNum;
    Boolean isAvailable=true;
    Tenant tenant;
    ArrayList<Tenant> potentialTenant;
    int rent;
    Lease lease;
    int rentStatus;
    String name;
    House(String name, int StreetNum,String streetName, String city, String postalCode) {
        super(streetName, city, postalCode);
        this.StreetNum=StreetNum;
        this.name=name;
    }
    @Override
    public String getType() {
        return "House";
    }
    @Override
    public String getInfo() {
        return "House (Monthly rent" + rent +") : " +  StreetNum +" "+ getStreetName() +" "+ getCity()
                +" "+ getPostalCode() ;
    }
    public void setPotentialTenant(Tenant t) {
        this.potentialTenant.add(t);
    }
    public Boolean isAvailable()
    {
        return isAvailable;
    }

    public void add_lease(Lease l)
    {
        lease=l;
    }
    public int getStreetNum() {
        return StreetNum;
    }

}
