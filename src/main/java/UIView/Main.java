package UIView;

import Controller.DatabaseController;
import ObserverPattern.ConcreteSubject;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) {
        DatabaseController.getInstance();
        ConcreteSubject leaseMonitor = new ConcreteSubject();
        launch(ManageProperty.class);
        launch(PropertyView.class);
        leaseMonitor.checkLease();
        //Todo call above three statements using multithreading
    }
}
