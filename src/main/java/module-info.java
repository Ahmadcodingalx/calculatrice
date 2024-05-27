module org.example.calculatrice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;


    opens org.example.calculatrice to javafx.fxml;
    exports org.example.calculatrice;

    opens org.example.calculatrice.game to javafx.fxml;
    exports org.example.calculatrice.game;

    opens org.example.calculatrice.calculatrice to javafx.fxml;
    exports org.example.calculatrice.calculatrice;

    opens org.example.calculatrice.dbconfig to javafx.fxml;
    exports org.example.calculatrice.dbconfig;

    opens org.example.calculatrice.models to javafx.fxml;
    exports org.example.calculatrice.models;
}