package main.Model;

public class Tenant {
    private String name;
    private String email;
    private String phoneNumber;
    public Tenant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public String getName() {
        return name;
    }
    public String getInfo() {
        return "Tenant{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
