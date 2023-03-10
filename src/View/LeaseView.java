package View;

import Controller.MockDatabaseController;
import Model.Lease;

import java.util.ArrayList;

public class LeaseView {

    public void DisplayAllLeases() {
        ArrayList<Lease> leases=MockDatabaseController.getAllLeases();
        for(Lease l:leases)
        {
            System.out.println(l.getInfo());
        }
    }
}
