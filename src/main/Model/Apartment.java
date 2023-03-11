
package main.Model;

import java.util.ArrayList;

public class Apartment {
    private int apartment_num;
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;
    boolean isAvailable;
    Tenant tenant;
    ArrayList<Tenant> potentialTenant;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    int Rent;
    Boolean RentStatus;

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public Lease getLease() {
        return lease;
    }

    Lease lease;
    public Apartment( int apartment_num, int numBedrooms, int numBathrooms, int squareFootage,int Rent) {
        this.apartment_num = apartment_num;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.Rent=Rent;
        this.isAvailable = true;
        potentialTenant = new ArrayList<>();
    }

    public Boolean getRentStatus() {
        return RentStatus;
    }

    public void setRentStatus(Boolean rentStatus) {
        RentStatus = rentStatus;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void addTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public ArrayList<Tenant> getPotentialTenant() {
        return potentialTenant;
    }

    public void addPotentialTenants(Tenant tenant) {
        this.potentialTenant.add(tenant);
    }

    public int getApartment_num() {
        return apartment_num;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    public int getNumBathrooms() {
        return numBathrooms;
    }

    public int getSquareFootage() {
        return squareFootage;
    }
    public int getRent()
    {
        return Rent;
    }

    public String getInfo() {
        String s="Apartment {" +
                "unitNumber='" + apartment_num + '\'' +
                ", numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", squareFootage=" + squareFootage +
                '}';
        return s;
    }
    public void add_lease(Lease l) {
        lease = l;

    }
    public void notify_tenant()
    {
        isAvailable=true;
        for(Tenant t:potentialTenant)
        {
            System.out.println("Tenant: "+t.getName()+"is notified");
        }
    }
}

