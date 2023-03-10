package View;

import static Controller.LeaseController.leases;
import Model.Lease;

public class LeaseView {


    public void DisplayAllLeases() {
        for(Lease l:leases)
        {
            System.out.println(l.getInfo());
        }
    }
}
