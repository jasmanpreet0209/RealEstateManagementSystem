
package Model;

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
        return "\nApartment {" +
                "  unitNumber='" + apartmentNum + '\'' +
                "\nnumBedrooms=" + numBedrooms       +
                "\nnumBathrooms=" + numBathrooms     +
                "\nsquareFootage=" + squareFootage   +
                '}';
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

