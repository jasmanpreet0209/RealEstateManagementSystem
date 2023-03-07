package Model;
import java.time.LocalDate;

public class Lease {
    private Tenant tenant;
    private LocalDate startDate;
    private Property property;
    private LocalDate endDate;
    private double rentAmount;

    public Lease(Tenant tenant, Property property, LocalDate startDate, LocalDate endDate, double rentAmount) {
        this.tenant = tenant;
        this.property = property;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
    }
    public Lease(Lease l)
    {
        this.tenant = l.tenant;
        this.property = l.property;
        this.startDate = l.startDate;
        this.endDate = l.endDate;
        this.rentAmount = l.rentAmount;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public Property getUnit() {
        return property;
    }

    public void setUnit(Property unit) {
        this.property = unit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }
}
