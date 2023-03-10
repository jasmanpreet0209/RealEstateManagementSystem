package View;

import java.util.Scanner;
import Model.*;
import Controller.*;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PropertyView PropView=new PropertyView();
        LeaseView leaseView=new LeaseView();
        TenantView tenantView=new TenantView();
        int choice = 0;
        do {
            System.out.println("Hello! Please choose the option:\n" +
                    " Select 1. Add a property\n" +
                    "2. Add a tenant\n" +
                    "3. Rent a unit\n" +
                    "4. Display properties \n5. Display tenants\n" +
                    "6. Display rented units \n7. Display vacant units\n" +
                    "8. Display all leases \n9. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    PropView.addProperty();
                    break;
                }
                case 2: {
                    tenantView.rentUnit();
                    break;
                }
                case 3: {
                    tenantView.rentUnit();
                    break;
                }
                case 4: {
                    PropView.displayProperties();
                    break;
                }
                case 5: {
                    tenantView.DisplayAllTenants();
                    break;
                }
                case 6: {
                    PropView.displayRentedUnits();
                    break;
                }
                case 7: {
                    PropView.displayVacantUnits();
                    break;
                }
                case 8: {
                    leaseView.DisplayAllLeases();
                    break;
                }
                case 9: {
                    System.out.println("Exitting the program! See you later");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Wrong input!try again");

            }
        }while (choice != 11);
    }
}