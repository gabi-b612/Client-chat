module org.chatapp.client {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.chatapp.client to javafx.fxml;
    exports org.chatapp.client;
}