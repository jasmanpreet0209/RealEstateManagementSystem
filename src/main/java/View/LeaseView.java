package View;

import Controller.MockDatabaseController;
import Model.Lease;

import java.util.ArrayList;

public class LeaseView {

    public void displayAllLeases() {
        ArrayList<Lease> leases=MockDatabaseController.getAllLeases();
        for(Lease l:leases)
        {
            System.out.println(l.getInfo());
        }
    }
}
