package org.example.calculatrice.models;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import org.example.calculatrice.calculatrice.CalcInterface;
import org.example.calculatrice.dbconfig.IDBConfig;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class History implements CalcInterface {
    private String recents;

    @Override
    public void virgule(ActionEvent event) {

    }

    @Override
    public void nombreEntié(MouseEvent event) {

    }

    @Override
    public void generale(MouseEvent event) {

    }

    @Override
    public void egale(MouseEvent event) {

    }

    @Override
    public void addHistoryShowData() {

    }

    @Override
    public void gameRedirection(MouseEvent event) throws IOException {

    }

    @Override
    public void historiques(String recents) throws SQLException {
        Connection connection = IDBConfig.getConnection();
        String req = "INSERT INTO hist_calc (Historique) VALUES (?)";
        assert connection != null;
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1, recents);

        int row = preparedStatement.executeUpdate();

        if (row == 0) {
            System.out.println("La creation du copmpte n'a pas abouti. Veuillez vérifier les information saisies");
        } else {
            System.out.println(String.valueOf(row));
        }

        //System.out.println(String.valueOf(row));
        preparedStatement.close();
        connection.close();
    }

    @Override
    public void number(MouseEvent event) {

    }
}
