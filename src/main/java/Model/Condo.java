
package Model;

import java.util.ArrayList;

public class Condo {
    private int condoNum;
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;
    int rent;
    Lease lease;
    Tenant tenant;
    boolean isAvailable;
    ArrayList<Tenant> potentialTenant;

    public Condo(int condoNum, int numBedrooms, int numBathrooms, int squareFootage, int Rent) {
        this.rent =Rent;
        this.condoNum = condoNum;
        this.isAvailable = true;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.potentialTenant = new ArrayList<>();
    }
    public String getInfo() {
        return "Condo {" +
                "  unitNumber='" + condoNum + '\''  +
                ", numBedrooms=" + numBedrooms      +
                ", numBathrooms=" + numBathrooms    +
                ", squareFootage=" + squareFootage  +
                ", rent=" + rent +
                '}';
    }
    public void notifyTenant()
    {
        isAvailable=true;
        for(Tenant t:potentialTenant)
        {
            System.out.println("Tenant: "+t.getName() + ": The Condo you were interested in is Available now");
            System.out.println(this.getInfo());
        }
    }
    // Getters and Setters
    public int getRent()
    {
        return rent;
    }
    public Lease getLease() {
        return lease;
    }
    public void setLease(Lease l)
    {
        lease=l;
    }
    public Tenant getTenant() {
        return tenant;
    }
    public int getCondoNum() {
        return condoNum;
    }
    public boolean isAvailable() { return isAvailable;}
    public void addTenants(Tenant tenant) {
        this.tenant = tenant;
    }
    public void setAvailable(boolean available) {isAvailable = available;}
    public ArrayList<Tenant> getPotentialTenant() {return potentialTenant;}
    public void addPotentialTenants(Tenant tenant) {
        this.potentialTenant.add(tenant);
    }
}

