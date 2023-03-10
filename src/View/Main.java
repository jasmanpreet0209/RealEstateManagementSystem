package View;

import Controller.MockDatabaseController;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        MockDatabaseController dbinstance = MockDatabaseController.getInstance();
        Scanner sc = new Scanner(System.in);
        PropertyView PropView=new PropertyView();
        LeaseView leaseView=new LeaseView();
        TenantView tenantView=new TenantView();
        int choice;
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
                case 1 -> PropView.addProperty();
                case 2, 3 -> tenantView.rentUnit();
                case 4 -> PropView.displayProperties();
                case 5 -> tenantView.DisplayAllTenants();
                case 6 -> PropView.displayRentedUnits();
                case 7 -> PropView.displayVacantUnits();
                case 8 -> leaseView.DisplayAllLeases();
                case 9 -> {
                    System.out.println("Exiting the program! See you later");
                    System.exit(0);
                }
                default -> System.out.println("Wrong input!try again");
            }
        }while (choice != 11);
    }
}