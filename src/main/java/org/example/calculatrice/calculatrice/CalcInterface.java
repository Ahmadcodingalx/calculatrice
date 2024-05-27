package org.example.calculatrice.calculatrice;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CalcInterface {

    @FXML
    void virgule(ActionEvent event);

    @FXML
    void nombreEntié(MouseEvent event);

    @FXML
    void generale(MouseEvent event);

    @FXML
    void egale(MouseEvent event) throws SQLException;

    void addHistoryShowData();

    @FXML
    void gameRedirection(MouseEvent event) throws IOException;

    void historiques(String recents) throws SQLException;

    @FXML
    void number(MouseEvent event);
}
