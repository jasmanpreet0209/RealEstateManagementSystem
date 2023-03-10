package Model;

public abstract class Property {
    String country;
    private String streetName;
    private String city;

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    private String postalCode;
    public Property(String street_name, String city, String postal_code) {
        this.streetName = street_name;
        this.city = city;
        this.postalCode = postal_code;
    }
    abstract String getType();
    public abstract String getBuildingName();
    public abstract String getInfo();
}
