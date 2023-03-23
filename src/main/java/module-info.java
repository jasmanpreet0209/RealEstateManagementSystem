module PropertyManagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens UIView to javafx.fxml;
    exports UIView;
}