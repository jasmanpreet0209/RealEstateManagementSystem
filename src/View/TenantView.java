package View;

import Controller.LeaseController;
import Controller.TenantController;
import Model.*;

import java.time.LocalDate;
import java.util.Scanner;

import static Controller.PropertiesController.properties;
import static Controller.LeaseController.leases;
import static Controller.TenantController.tenants;
public class TenantView {
    TenantController tc;
    LeaseController lc;
    TenantView()
    {
        this.tc=new TenantController();
        this.lc=new LeaseController();
    }
    public void DisplayAllTenants()
    {
        for(Tenant t:tenants)
        {
            System.out.println(t.getInfo());
        }
    }
    public void addTenantAfterInput() {

        //tc.addTenant(BuildingName,unit,t);

    }

    public void rentUnit() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter Email");
        String email=sc.nextLine();
        System.out.println("Enter phone number");
        String phone=sc.nextLine();
        Tenant t=new Tenant(name,email,phone);
        System.out.println("Please select the property type that the tenant is interested in :\n " +
                "1.Apartment building\n 2.condo building" +
                "\n 3.House");
        int choice=Integer.parseInt(sc.nextLine());
        System.out.println("Enter building name");
        String BuildingName=sc.nextLine();
        int unit=0;
        if(choice!=3) {
            System.out.println("Enter unit number of the property you are interested in");
            unit=Integer.parseInt(sc.nextLine());
        }
        for(Property p : properties)
        {
            if(p.getBuildingName().equals(BuildingName))
            {
                if(p instanceof CondoBuilding c)
                {
                    Condo condo= c.getCondos().get(unit);
                    if(condo.isAvailable())
                    {
                        lc.addLease(LocalDate.now(),LocalDate.now().plusYears(1),t,condo.getInfo(),condo.getRent(),unit);

                    }
                    else
                    {
                        tc.addTenant(condo.getInfo(),unit,t);
                    }
                }
                else if(p instanceof ApartmentBuilding a)
                {
                    Apartment apartment= a.getApartments().get(unit);
                    if(apartment.isAvailable())
                    {
                        lc.addLease(LocalDate.now(),LocalDate.now().plusYears(1),t,apartment.getInfo(),apartment.getRent(),unit);

                    }
                    else {
                        tc.addTenant(apartment.getInfo(), unit,t);
                    }
                }
                else
                {
                    House h = (House) p;
                    if(h.getAvailable()==true)
                    {
                        lc.addLease(LocalDate.now(),LocalDate.now().plusYears(1),t,h.getInfo(),h.getRent(),unit);

                    }
                    else
                    {
                        tc.addTenant(h.getInfo(),0,t);
                    }
                }
            }
        }
    }
}
