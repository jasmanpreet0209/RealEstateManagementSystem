
package main.Model;

import java.util.ArrayList;

public class Apartment {
    private int apartmentNum;
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;
    int rent;
    Lease lease;
    Tenant tenant;
    boolean isAvailable;
    ArrayList<Tenant> potentialTenant;
    public Apartment( int apartmentNum, int numBedrooms, int numBathrooms, int squareFootage,int rent) {
        this.rent =rent;
        this.isAvailable = true;
        this.apartmentNum = apartmentNum;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.potentialTenant = new ArrayList<>();
    }
    public String getInfo() {
        return "Apartment {" +
                "  unitNumber='" + apartmentNum + '\'' +
                ", numBedrooms=" + numBedrooms       +
                ", numBathrooms=" + numBathrooms     +
                ", squareFootage=" + squareFootage   +
                '}';
    }
    public void notifyTenant()
    {
        isAvailable=true;
        for(Tenant t:potentialTenant)
        {
            System.out.println("Tenant: "+t.getName()+"is notified");
        }
    }
    // Getter and Setters
    public int getRent()
    {
        return rent;
    }
    public Lease getLease() {
        return lease;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public void setLease(Lease l) { this.lease = l;}
    public boolean isAvailable() {
        return isAvailable;
    }
    public void addTenant(Tenant tenant) {
        this.tenant = tenant;
    }
    public void setAvailable(boolean available) {isAvailable = available;}
    public void addPotentialTenants(Tenant tenant) {
        this.potentialTenant.add(tenant);
    }
    public ArrayList<Tenant> getPotentialTenant() {
        return potentialTenant;
    }
}

