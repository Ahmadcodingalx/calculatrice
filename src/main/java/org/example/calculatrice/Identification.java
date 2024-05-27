package org.example.calculatrice;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.example.calculatrice.game.GameController;

import java.io.IOException;

public class Identification {
    @FXML
    private TextField nameZone;

    public String name;

    @FXML
    private Label avertissement;

    @FXML
    public void submit() throws IOException {

        name = nameZone.getText();


        if (name.isEmpty()) {
            avertissement.setText("Vous devez saisir un nom avant de continuer");
        } else {



            Stage initial = (Stage) nameZone.getScene().getWindow();
            initial.close();
            Stage stage = new Stage();

            stage.setUserData("bonjourADN");

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Game.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Game");
            stage.setScene(scene);
            stage.show();
        }

    }

    public String getName() {
        return name;
    }
}
