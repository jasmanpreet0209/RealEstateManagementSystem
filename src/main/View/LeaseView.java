package main.View;

import main.Controller.MockDatabaseController;
import main.Model.Lease;

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
