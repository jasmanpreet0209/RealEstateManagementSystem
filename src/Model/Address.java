package Model;

public class Address
{
    private String streetNumber;
    private String streetName;
    private String city;
    private String postalCode;

    public Address( String streetName, String city, String postalCode) {
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return streetNumber + " " + streetName + ", " + city + ", " + postalCode;
    }
}
