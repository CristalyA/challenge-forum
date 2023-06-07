module com.example.loja_virtual_alura {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires c3p0;
    requires java.naming;


    opens com.example.loja_virtual_alura to javafx.fxml;
    exports com.example.loja_virtual_alura;
}