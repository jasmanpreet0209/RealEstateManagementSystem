package View;

import Controller.LeaseController;
import Controller.MockDatabaseController;
import Controller.TenantController;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TenantView {
    TenantController tc;
    LeaseController lc;

    Scanner sc=new Scanner(System.in);
    TenantView()
    {
        this.tc=new TenantController();
        this.lc=new LeaseController();
    }
    public void DisplayAllTenants()
    {
        ArrayList<Tenant> tenants = MockDatabaseController.getAllTenants();
        for(Tenant t:tenants)
        {
            System.out.println(t.getInfo());
        }
    }
    public void rentUnit() {
        System.out.println("Enter name");
        String name=sc.nextLine();
        System.out.println("Enter Email");
        String email=sc.nextLine();
        System.out.println("Enter phone number");
        String phone=sc.nextLine();
        Tenant t=new Tenant(name,email,phone);
        System.out.println("""
                Please select the property type that the tenant is interested in :
                 1.Apartment building
                 2.condo building
                 3.House""");
        int choice=Integer.parseInt(sc.nextLine());
        String buildingName;
        int unit=0;
        if(choice!=3) {
            System.out.println("Enter building name");
            buildingName=sc.nextLine();
            System.out.println("Enter unit number of the property you are interested in");
            unit=Integer.parseInt(sc.nextLine());
        }
        else
        {
            System.out.println("Enter house number");
            String h = sc.nextLine();
            System.out.println("Enter Street name");
            String street = sc.nextLine();
            buildingName = h+ " " + street;
        }
        Property property = MockDatabaseController.getProperty(buildingName);
        if(property!=null)
        {
                if(property instanceof CondoBuilding building)
                {
                    Condo condo = null;
                    for(Condo c : building.getCondos())
                    {
                        if(c.getCondo_num() == unit)
                        {
                            condo = c;
                            break;
                        }
                    }
                    boolean flag=true;
                    for(Condo c : building.getCondos())
                    {
                        if (c.getCondo_num() == unit) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                    {
                        System.out.println("This unit does not exist! Please express your interest in another unit!");
                        return;
                    }
                    if(condo==null)
                    {
                        System.out.println("There is no condo unit :" + unit + " available!! Enter valid condo unit\n");
                        return;
                    }

                    if(condo.isAvailable())
                    {
                        lc.addLease(LocalDate.now(),LocalDate.now().plusYears(1),t,building.getBuildingName(),condo.getRent(),unit);
                    }
                    else
                    {
                        System.out.println("The condo you are looking is not available!!\n Adding you to the interested tenant list");
                        tc.addTenant(condo.getInfo(),unit,t);
                    }
                }
                else if(property instanceof ApartmentBuilding a)
                {
                    Apartment apartment= a.getApartments().get(unit-1);
                    if(apartment.isAvailable())
                    {
                        lc.addLease(LocalDate.now(),LocalDate.now().plusYears(1),t,a.getBuilding_name(),apartment.getRent(),unit);
                    }
                    else {
                        System.out.println("The apartment you are looking is not available!!\n Adding you to the interested tenant list");
                        tc.addTenant(apartment.getInfo(), unit,t);
                    }
                }
                else {
                    House h = (House) property;
                    if (h.getAvailable()) {
                        lc.addLease(LocalDate.now(), LocalDate.now().plusYears(1), t, h.getBuildingName(), h.getRent(), unit);

                    } else {
                        System.out.println("The house you are looking is not available!!\n Adding you to the interested tenant list");
                        tc.addTenant(h.getInfo(), 0, t);
                    }
                }
        }
        else
        {
            System.out.println("Enter correct property details");
        }
    }

}
