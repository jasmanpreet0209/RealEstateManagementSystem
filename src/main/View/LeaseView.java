package main.View;

import main.Controller.MockDatabaseController;
import main.Model.Lease;

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
