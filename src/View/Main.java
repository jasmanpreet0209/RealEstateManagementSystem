package View;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PropertyView PropView=new PropertyView();
        LeaseView leaseView=new LeaseView();
        TenantView tenantView=new TenantView();
        int choice = 0;
        do {
            System.out.println("""
                    Hello! Please choose the option:
                    Select 
                    1. Add a property
                    2. Add a tenant
                    3. Rent a unit
                    4. Display properties\s
                    5. Display tenants
                    6. Display rented units\s
                    7. Display vacant units
                    8. Display all leases\s
                    9. Exit""");
            choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    PropView.addProperty();
                    break;
                }
                case 2 -> {
                    tenantView.rentUnit();
                    break;
                }
                case 3 -> {
                    tenantView.rentUnit();
                    break;
                }
                case 4 -> {
                    PropView.displayProperties();
                    break;
                }
                case 5 -> {
                    tenantView.DisplayAllTenants();
                    break;
                }
                case 6 -> {
                    PropView.displayRentedUnits();
                    break;
                }
                case 7 -> {
                    PropView.displayVacantUnits();
                    break;
                }
                case 8 -> {
                    leaseView.DisplayAllLeases();
                    break;
                }
                case 9 -> {
                    System.out.println("Exiting the program! See you later");
                    System.exit(0);
                    break;
                }
                default -> System.out.println("Wrong input!try again");
            }
        }while (choice != 11);
    }
}