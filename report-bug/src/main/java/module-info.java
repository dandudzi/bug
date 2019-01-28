module com.bug.main {
    requires javafx.controls;
    requires javafx.fxml;
    requires spring.context;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires static lombok;

    opens com.bug.main to javafx.fxml;

}