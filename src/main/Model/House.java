package main.Model;

import java.util.ArrayList;

public class House extends Property{
    int rent;
    Lease lease;
    Tenant tenant;
    String houseNumber;
    Boolean isAvailable;
    private int streetNum;
    ArrayList<Tenant> potentialTenant;
    public House(String hNum, int streetNum, String streetName, String city, String postalCode,int rent) {
        super(streetName, city, postalCode);
        this.streetNum =streetNum;
        this.houseNumber =hNum;
        this.rent = rent;
        potentialTenant = new ArrayList<>();
        isAvailable = true;
    }
    public void notifyTenant()
    {
        isAvailable=true;
        for(Tenant t:potentialTenant)
        {
            System.out.println("Tenant: "+t.getName() + ": The House you were interested in is Available now");
            System.out.println(this.getInfo());
        }
    }
    @Override
    public String getInfo() {
        return "House (Monthly rent " + rent +") : " + streetNum +" "+ getStreetName() +" "+ getCity()
                +" "+ getPostalCode() ;
    }
    // Getters and setters
    public int getRent() {
        return rent;
    }
    public Lease getLease() {return lease; }
    public void setLease(Lease l) { lease=l;}
    @Override
    public String getType() { return "House";}
    public Tenant getTenant() { return tenant; }
    public Boolean getAvailable() {return isAvailable; }
    public void addTenants(Tenant tenant) { this.tenant = tenant; }
    public void setAvailable(Boolean available) { isAvailable = available; }
    @Override
    public String getBuildingName() { return houseNumber +" " + getStreetName(); }
    public void addPotentialTenants(Tenant tenant) { this.potentialTenant.add(tenant);}
}