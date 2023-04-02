package Model;

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
    public String notifyTenant()
    {
        isAvailable=true;
        String message="";
        boolean flag=false;
        for(Tenant t:potentialTenant)
        {
            message += "Tenant: "+t.getName() + ": The Apartment you were interested in is Available now" + " " + this.getInfo()+"\n\n";
            System.out.println(message);
            flag=true;

        }
        for (int i=0;i<potentialTenant.size();i++)
        {
            potentialTenant.remove(0);
        }
        return message;
    }

    @Override
    public String getInfo() {
        return "\nHouse (Monthly rent " + rent +") : \nStreet Number: " + streetNum +" \nStreet Name: "+ getStreetName() +"\nCity Name:  "+ getCity()
                +" \nPostal Code: "+ getPostalCode() ;

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
    public ArrayList<Tenant> getPotentialTenants() { return potentialTenant;}
    @Override
    public String getBuildingName() { return houseNumber +" " + getStreetName(); }
    public void addPotentialTenants(Tenant tenant) { this.potentialTenant.add(tenant);}
}