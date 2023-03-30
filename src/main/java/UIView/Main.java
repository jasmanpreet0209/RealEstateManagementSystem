package UIView;

import Controller.DatabaseController;
import ObserverPattern.ConcreteSubject;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DatabaseController.getInstance();
        ManageProperty task2 = new ManageProperty();
        ConcreteSubject task3 =  new ConcreteSubject();
        task2.run();
        task3.run();
    }
}