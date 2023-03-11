package main.Model;

import java.time.LocalDate;

public class Lease {
    private Tenant tenant;
    private LocalDate startDate;
    private String propertyInfo;
    private LocalDate endDate;
    private double rentAmount;

    public Lease(Tenant tenant, String propertyInfo, LocalDate startDate, LocalDate endDate, double rentAmount) {
        this.tenant = tenant;
        this.propertyInfo = propertyInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
    }
    public String getInfo()
    {
        return "Lease: \n Tenant info:\n"+ tenant.getInfo()+"\n Start Date:" +startDate+
                "\nEndDate:"+endDate+"\nRent Amount"+rentAmount+"\nProperty info:"+ propertyInfo;
    }
    public Tenant getTenant() {
        return tenant;
    }

    public void setInfo(String propertyInfo) {
        this.propertyInfo = propertyInfo;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

}
