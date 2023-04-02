package UIView;

import Controller.DatabaseController;
import ObserverPattern.ConcreteSubject;

import static javafx.application.Application.launch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DatabaseController.getInstance();
        ManageProperty task2 = new ManageProperty();
        ConcreteSubject task3 =  new ConcreteSubject();
        Thread thread2 = new Thread(task2);
        thread2.start();

    }
}