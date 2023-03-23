package Model;

public abstract class Property {
    private String city;
    private String streetName;
    private String postalCode;
    public Property(String streetName, String city, String postalCode) {
        this.city = city;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }
    abstract String getType();
    public abstract String getInfo();
    public String getCity() {
        return city;
    }
    public abstract String getBuildingName();
    public String getStreetName() {
        return streetName;
    }
    public String getPostalCode() {
        return postalCode;
    }
}
