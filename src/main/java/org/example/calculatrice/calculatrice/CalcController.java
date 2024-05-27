package org.example.calculatrice.calculatrice;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.calculatrice.HelloApplication;
import org.example.calculatrice.dbconfig.Database;
import org.example.calculatrice.dbconfig.IDBConfig;
import org.example.calculatrice.models.HistData;
import org.example.calculatrice.models.History;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class CalcController implements CalcInterface, Initializable {

    @FXML
    private TextField answerZone;

    @FXML
    private TextField operationZone;

    private String actionGenerale;

    private double firstNumber;

    private double result = 0;

    private boolean decimaleClick = true;

    private double secondNumber;

    @FXML
    private ChoiceBox<String> calc_type;

    private Statement statement;

    @FXML
    private TableColumn<HistData, String> historyOfCalc;

    @FXML
    private TableView<HistData> historyTable;

    @Override
    @FXML
    public void virgule(ActionEvent event) {
      if(decimaleClick) {
          String nmbrdecimale = ((Button)event.getSource()).getText();
          String ancienNombre = answerZone.getText();
          String nouveauNombre = ancienNombre + nmbrdecimale;
          answerZone.setText(nouveauNombre);
          decimaleClick = false;
      }
    }

    private String hist(String signe) {

        String format = String.format("%.2f" ,result);
        answerZone.setText(format);

        String hist1 = String.valueOf(firstNumber);
        String hist2 = String.valueOf(secondNumber);
        String historique = hist1 + " " + signe + " " + hist2 + " " + "=" + " " + format;
        String operation = hist1 + " " + signe + " " + hist2;
        operationZone.setText(operation);
        return historique;
    }

    @Override
    @FXML
    public void nombreEntié(MouseEvent event) {
        String nmbrEntier = ((Button)event.getSource()).getText();
        String ancienNombre = answerZone.getText();
        String nouveauNombre = ancienNombre + nmbrEntier;
        answerZone.setText(nouveauNombre);
    }

    @Override
    @FXML
    public void generale(MouseEvent event) {
        actionGenerale = ((Button)event.getSource()).getText();
        switch (actionGenerale) {
            case "C" :
                reset();
                decimaleClick = true;
                break;
            case "+/-" :
                double changeSigne = Double.parseDouble(answerZone.getText());
                changeSigne = changeSigne * (-1);
                answerZone.setText(String.valueOf(changeSigne));
                break;
            case "+" :
            case "-" :
            case "*" :
            case "/" :
            case "EXP" :
            case "%" :
                String firstText = answerZone.getText();
                firstNumber = Double.parseDouble(firstText);
                answerZone.setText("");
                operationZone.setText(String.valueOf(firstNumber));
                decimaleClick = true;
                break;
            default:
        }
    }

    public void reset() {
        operationZone.setText("");
        answerZone.setText("");
    }

    public ObservableList<HistData> addHistoryListeData() {
        ObservableList<HistData> histList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM hist_calc";

        //   DATABASE TOOLS
        Connection connection = Database.connectDb();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                HistData hist = new HistData(resultSet.getString("historique"));
                histList.add(hist);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        return histList;
    }

    @Override
    @FXML
    public void egale(MouseEvent event) throws SQLException {

        String secondText = answerZone.getText();

        secondNumber = Double.parseDouble(secondText);

        History history = new History();
        switch (actionGenerale) {
            case "+" :
                result = firstNumber + secondNumber;
                hist("+");
                history.historiques(hist("+"));
                break;
            case "-" :
                result = firstNumber - secondNumber;
                hist("-");
                history.historiques(hist("-"));
                break;
            case "/" :
                result = firstNumber / secondNumber;
                hist("/");
                history.historiques(hist("/"));
                break;
            case "*" :
                result = firstNumber * secondNumber;
                hist("*");
                history.historiques(hist("*"));
                break;
            default:
        }
        String format = String.format("%.2f" ,result);
        answerZone.setText(format);

        addHistoryShowData();
    }

    @Override
    public void addHistoryShowData() {

        ObservableList<HistData> addHistorylist = addHistoryListeData();

        historyOfCalc.setCellValueFactory(new PropertyValueFactory<>("historiques"));

        historyTable.setItems(addHistorylist);

    }

    @Override
    @FXML
    public void gameRedirection(MouseEvent event) throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("identification.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Identification...");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void historiques(String recents) throws SQLException {
        addHistoryShowData();
    }

    @FXML
    void deleteHist() throws SQLException {
        Connection connection = IDBConfig.getConnection();
        String req = "DELETE FROM hist_calc";

        try {

            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(req);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //----------------------------------------------------------------------------------------------


    @FXML
    private Text DF_droite;

    @FXML
    private Text DF_guache;

    @FXML
    private Label DF_tableauDeSigne;

    @FXML
    private Text Derive_fx_a;

    @FXML
    private Text Derive_fx_a1;

    @FXML
    private Text Derive_fx_b;

    @FXML
    private Text Derive_fx_b1;

    @FXML
    private Text Derive_fx_c;

    @FXML
    private Text Derive_fx_c1;

    @FXML
    private Text Derive_fx_d;

    @FXML
    private Text Derive_fx_d1;

    @FXML
    private Text Derive_fx_e;

    @FXML
    private Text Derive_fx_e1;

    @FXML
    private Label Lim_DF1;

    @FXML
    private Label Lim_DF2;

    @FXML
    private Label Lim_signe_DF1;

    @FXML
    private Label Lim_signe_DF2;

    @FXML
    private TextField a;

    @FXML
    private Text a_tableauDeSigne;

    @FXML
    private TextField b;

    @FXML
    private Text b_tableauDeSigne;

    @FXML
    private TextField c;

    @FXML
    private ChoiceBox<?> calc_type1;

    @FXML
    private TextField d;

    @FXML
    private TextField e;

    @FXML
    private Label signe1_tableauDeSigne;

    @FXML
    private Label signe2_tableauDeSigne;

    @FXML
    private AnchorPane standard_screen;

    @FXML
    private AnchorPane Fonctions;

    @FXML
    private AnchorPane Standard;

    @FXML
    private Text Calc_types;

    @FXML
    private Label Calc_types2;

    @FXML
    private Label Lim_signe_infini1;

    @FXML
    private Label Lim_signe_infini2;


    //----------------------------------------------------------------------------------------------

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        calc_type.getItems().addAll("Standard", "Fonctions");
        calc_type.setValue("Standard");
        addHistoryShowData();
    }

    public void changeMode() {
//        if (true) {
//            Standard.setVisible(false);
//        }
        String types = Calc_types2.getText();
        if (types.equals("Standard")) {
            Standard.setVisible(false);
            Fonctions.setVisible(true);
            Calc_types2.setText("Fonctions");
        } else {
            Standard.setVisible(true);
            Fonctions.setVisible(false);
            Calc_types2.setText("Standard");
        }
    }

    CalcFonctionController calcFonction = new CalcFonctionController();

    public void number(MouseEvent event) {

        String nmbrEntier = ((Button)event.getSource()).getText();
        String ancienNombre = a.getText();
        String nouveauNombre = ancienNombre + nmbrEntier;
        a.setText(nouveauNombre);

    }

    public void infosSend() {

        calcFonction.setA(Double.parseDouble(a.getText()));
        calcFonction.setB(Double.parseDouble(b.getText()));
        calcFonction.setC(Double.parseDouble(c.getText()));
        calcFonction.setD(Double.parseDouble(d.getText()));
        calcFonction.setE(Double.parseDouble(e.getText()));

    }

    public void DDeF() {

        double Df1 = (-calcFonction.e / calcFonction.d);
        String df = String.format("%.2f" ,Df1);
        DF_droite.setText(String.valueOf(df));
        DF_guache.setText(String.valueOf(df));
        DF_tableauDeSigne.setText(String.valueOf(df));
        a_tableauDeSigne.setText(d.getText());
        b_tableauDeSigne.setText(e.getText());

        if (calcFonction.getD() > 0) {
            signe1_tableauDeSigne.setText("-");
            signe2_tableauDeSigne.setText("+");
        } else {
            signe1_tableauDeSigne.setText("+");
            signe2_tableauDeSigne.setText("-");
        }

    }

    public void limite() {
        double a1 = calcFonction.a;
        double b1 = calcFonction.b;
        double c1 = calcFonction.c;
        double Df1 = (-calcFonction.e / calcFonction.d);
        String df = String.format("%.2f" ,Df1);

        Lim_DF1.setText(df);
        Lim_DF2.setText(df);

        if ( (calcFonction.a / calcFonction.d) > 0) {
            Lim_signe_infini1.setText("-oo");
            Lim_signe_infini2.setText("+oo");
        } else {
            Lim_signe_infini1.setText("+oo");
            Lim_signe_infini2.setText("-oo");
        }

        double N = ((a1 * (Df1 * Df1)) + (b1 * Df1) + c1);
        System.out.println(N);
        System.out.println(Df1);
        System.out.println(a1);
        System.out.println(b1);
        System.out.println(c1);
        System.out.println(calcFonction.a);

        if (N > 0) {
            if (calcFonction.getD() > 0) {
                Lim_signe_DF1.setText("-");
                Lim_signe_DF2.setText("+");
            } else {
                Lim_signe_DF1.setText("+");
                Lim_signe_DF2.setText("-");

            }
        } else {
            if (calcFonction.getD() > 0) {
                Lim_signe_DF1.setText("-");
                Lim_signe_DF2.setText("+");
            } else {
                Lim_signe_DF1.setText("+");
                Lim_signe_DF2.setText("-");
            }
        }

    }

    public void deriver() {
        Derive_fx_a.setText(a.getText());
        Derive_fx_b.setText(b.getText());
        Derive_fx_c.setText(c.getText());
        Derive_fx_d.setText(d.getText());
        Derive_fx_e.setText(e.getText());
    }

    public void launch() {

        infosSend();
        calcFonction.etudeDeFonction();

        DDeF();
        limite();
        deriver();
    }

    public void clear() {
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        e.setText("");
    }
}
