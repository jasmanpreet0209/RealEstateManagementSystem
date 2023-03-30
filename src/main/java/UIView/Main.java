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
        Thread thread3 = new Thread(task3);
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
    }
}