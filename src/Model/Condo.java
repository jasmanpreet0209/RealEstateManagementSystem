
package Model;

import java.util.ArrayList;

public class Condo {
    private int condo_num;
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;
    boolean isAvailable=true;
    ArrayList<Tenant> tenants;
    ArrayList<Tenant> potentialTenant;
    int Rent;
    int RentStatus;
    Lease lease;
    public Condo(int condo_num, int numBedrooms, int numBathrooms, int squareFootage, int Rent) {
        this.condo_num = condo_num;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.Rent=Rent;
    }
    public void add_lease(Lease l)
    {
        lease=l;
    }

    public int getCondo_num() {
        return condo_num;
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

    @Override
    public String toString() {
        return "Condo {" +
                "unitNumber='" + condo_num + '\'' +
                ", numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", squareFootage=" + squareFootage +
                '}';
    }
}

