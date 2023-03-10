package Model;

import java.util.ArrayList;

public class House extends Property{

    private int StreetNum;
    Boolean isAvailable=true;
    Tenant tenant;
    ArrayList<Tenant> potentialTenant;
    int rent;
    Lease lease;
    Boolean rentStatus;

    public Boolean getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(Boolean rentStatus) {
        this.rentStatus = rentStatus;
    }

    String name;
    public House(String name, int StreetNum, String streetName, String city, String postalCode) {
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
    public Tenant getTenant() {
        return tenant;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
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
        return StreetNum;
    }

}
