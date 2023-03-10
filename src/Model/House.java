package Model;

import java.util.ArrayList;

public class House extends Property{

    private int streetNum;
    Boolean isAvailable;
    Tenant tenant;
    ArrayList<Tenant> potentialTenant;
    int rent;
    Lease lease;
    String houseNumber;
    public House(String hNum, int streetNum, String streetName, String city, String postalCode,int rent) {
        super(streetName, city, postalCode);
        this.streetNum =streetNum;
        this.houseNumber =hNum;
        this.rent = rent;
        potentialTenant = new ArrayList<>();
        isAvailable = true;
    }
    @Override
    public String getBuildingName() {
        return houseNumber +" " + getStreetName();
    }

    @Override
    public String getType() {
        return "House";
    }
    @Override
    public String getInfo() {
        return "House (Monthly rent " + rent +") : " + streetNum +" "+ getStreetName() +" "+ getCity()
                +" "+ getPostalCode() ;
    }
    public Tenant getTenant() {
        return tenant;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = true;
    }


    public void addTenants(Tenant tenant) {
        this.tenant = tenant;
    }

    public ArrayList<Tenant> getPotentialTenant() {
        return potentialTenant;
    }

    public void addPotentialTenants(Tenant tenant) {
        this.potentialTenant.add(tenant);
    }
    public void setPotentialTenant(Tenant t) {
        this.potentialTenant.add(t);
    }

    public void add_lease(Lease l)
    {
        lease=l;
    }
    public int getStreetNum() {
        return streetNum;
    }

    public int getRent() {
        return rent;
    }

}
