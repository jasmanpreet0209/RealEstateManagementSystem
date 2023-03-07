
package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Apartment {
    private String apartment_num;
    private int numBedrooms;
    private int numBathrooms;
    private int squareFootage;
    boolean isAvailable=true;
    ArrayList<Tenant> tenants;
    ArrayList<Tenant> potentialTenant;
    int Rent;
    int RentStatus;
    Lease lease;
    public Apartment( String apartment_num, int numBedrooms, int numBathrooms, int squareFootage,int Rent) {
        this.apartment_num = apartment_num;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFootage = squareFootage;
        this.Rent=Rent;
    }


    public String getApartment_num() {
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

    @Override
    public String toString() {
        return "Apartment {" +
                "unitNumber='" + apartment_num + '\'' +
                ", numBedrooms=" + numBedrooms +
                ", numBathrooms=" + numBathrooms +
                ", squareFootage=" + squareFootage +
                '}';
    }
    public void add_lease(Lease l)
    {
        lease=l;
    }

}

