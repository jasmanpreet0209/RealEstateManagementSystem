package main.Model;

import java.time.LocalDateTime;

public class Lease {
    private Tenant tenant;
    private LocalDateTime startDate;
    private String propertyInfo;
    private LocalDateTime endDate;
    private double rentAmount;

    public Lease(Tenant tenant, String propertyInfo, LocalDateTime startDate, LocalDateTime endDate, double rentAmount) {
        this.tenant = tenant;
        this.propertyInfo = propertyInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
    }
    public String getInfo()
    {
        return "Lease: \nTenant info:\n"+ tenant.getInfo()+"\nStart Date:" +startDate+
                "\nEndDate:"+endDate+"\nRent Amount"+rentAmount+"\nProperty info:"+ propertyInfo +"\n";
    }
    public Tenant getTenant() {
        return tenant;
    }

    public void setPropertyInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

}
