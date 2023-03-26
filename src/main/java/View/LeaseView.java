package View;

import Controller.DatabaseController;
import Model.Lease;

import java.util.ArrayList;

public class LeaseView {

    public void displayAllLeases() {
        ArrayList<Lease> leases= DatabaseController.getAllLeases();
        for(Lease l:leases)
        {
            System.out.println(l.getInfo());
        }
    }
}
