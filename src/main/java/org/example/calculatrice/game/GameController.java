package org.example.calculatrice.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.calculatrice.HelloApplication;
import  org.example.calculatrice.Identification;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************

//    @FXML
//    private TextField nameZone;
//
//    public String name;
//
//    @FXML
//    private Label avertissement;
//
//    @FXML
//    public void submit() throws IOException {
//
//        name = nameZone.getText();
//
//
//        if (name.isEmpty()) {
//            avertissement.setText("Vous devez saisir un nom avant de continuer");
//        } else {
//
//
//
//            Stage initial = (Stage) nameZone.getScene().getWindow();
//            initial.close();
//            Stage stage = new Stage();
//
//            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Game.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setTitle("Game");
//            stage.setScene(scene);
//            stage.show();
//        }
//
//    }

    //******************************************************************************************************************
    //******************************************************************************************************************
    //******************************************************************************************************************

    public String username;

    Identification identification = new Identification();
    String userName = identification.getName();



    //Ici les quelques variables pour certains text
    private final String color1 = "Messages";
    private final String color2 = "Zone de jeu";
    private final String color3 = "Fond d'écran";

    private final String stop1 = "Fait attention !!!";
    private final String stop2 = "Fond d'écran";

    private int nombreEssaies = 1;


    //les boolean utiliser pour marquer certaines zone
    private boolean num1;
    private boolean declenchements;
    private boolean but14;
    private boolean but16;
    private boolean but17;
    private boolean but21;
    private boolean but23;
    private boolean but25;
    private boolean testArrive1, testArrive2, testArrive3, testArrive4, defeat = true, win = false, booltext, bool;

    //Les fxID de touts les éléments du jeux
    @FXML
    private Line blocusshow1;

    @FXML
    private Line blocusshow10;

    @FXML
    private Line blocusshow2;

    @FXML
    private Line blocusshow3;

    @FXML
    private Line blocusshow4;

    @FXML
    private Line blocusshow5;

    @FXML
    private Line blocusshow6;

    @FXML
    private Line blocusshow7;

    @FXML
    private Line blocusshow8;

    @FXML
    private Line blocusshow9;

    @FXML
    private Button colorbutton21;

    @FXML
    private Button colorbutton1;

    @FXML
    private Button colorbutton10;

    @FXML
    private Button colorbutton11;

    @FXML
    private Button colorbutton12;

    @FXML
    private Button colorbutton13;

    @FXML
    private Button colorbutton14;

    @FXML
    private Button colorbutton15;

    @FXML
    private Button colorbutton16;

    @FXML
    private Button colorbutton17;

    @FXML
    private Button colorbutton18;

    @FXML
    private Button colorbutton19;

    @FXML
    private Button colorbutton2;

    @FXML
    private Button colorbutton20;

    @FXML
    private Button colorbutton22;

    @FXML
    private Button colorbutton23;

    @FXML
    private Button colorbutton24;

    @FXML
    private Button colorbutton25;

    @FXML
    private Button colorbutton26;

    @FXML
    private Button colorbutton27;

    @FXML
    private Button colorbutton28;

    @FXML
    private Button colorbutton29;

    @FXML
    private Button colorbutton3;

    @FXML
    private Button colorbutton4;

    @FXML
    private Button colorbutton5;

    @FXML
    private Button colorbutton6;

    @FXML
    private Button colorbutton7;

    @FXML
    private Button colorbutton8;

    @FXML
    private Button colorbutton9;

    @FXML
    private Button reset1;

    @FXML
    private Button reset10;

    @FXML
    private Button reset2;

    @FXML
    private Button reset3;

    @FXML
    private Button reset4;

    @FXML
    private Button reset5;

    @FXML
    private Button reset6;

    @FXML
    private Button reset7;

    @FXML
    private Button reset8;

    @FXML
    private Button reset9;

    @FXML
    private Button commencer;

    @FXML
    private ChoiceBox<String> colorchoice; //Liste de choix

    @FXML
    private ColorPicker couleur;

    @FXML
    private ImageView defeatimage; //affichage de l'image à la défaite

    @FXML
    private AnchorPane gamebackground1; //Zone de jeu

    @FXML
    private ImageView imageshow; //image qui s'affiche l'ors d'un blocus

    @FXML
    private Text message;

    @FXML
    private Text message1;

    @FXML
    private Text regle1;

    @FXML
    private Text regle2;

    @FXML
    private ImageView successimage; //affichage de l'image à la réussite

    @FXML
    private HBox windowbackgroundcolor; //fond de l'ecran

    @FXML
    private ImageView arrivé;

    @FXML
    private ImageView depart;

    @FXML
    private ImageView icones10;

    @FXML
    private ImageView icones11;

    @FXML
    private ImageView icones21;

    @FXML
    private ImageView icones25;

    @FXML
    private ImageView icones7;

    @FXML
    private ImageView icones8;

    public GameController() throws IOException {
    }


    void colorbackground() {
        /* Color col = couleur.getValue();
        gamebackground1.setBackground(Background.fill(col));
        colorbutton1.setBackground(Background.fill(col));
        colorbutton2.setBackground(Background.fill(col));
        colorbutton3.setBackground(Background.fill(col));
        colorbutton4.setBackground(Background.fill(col));
        colorbutton5.setBackground(Background.fill(col));
        colorbutton6.setBackground(Background.fill(col));
        colorbutton7.setBackground(Background.fill(col));
        colorbutton8.setBackground(Background.fill(col));
        colorbutton9.setBackground(Background.fill(col));
        colorbutton10.setBackground(Background.fill(col));
        colorbutton11.setBackground(Background.fill(col));
        colorbutton12.setBackground(Background.fill(col));
        colorbutton13.setBackground(Background.fill(col));
        colorbutton14.setBackground(Background.fill(col));
        colorbutton15.setBackground(Background.fill(col));
        colorbutton16.setBackground(Background.fill(col));
        colorbutton17.setBackground(Background.fill(col));
        colorbutton18.setBackground(Background.fill(col));
        colorbutton19.setBackground(Background.fill(col));
        colorbutton20.setBackground(Background.fill(col));
        colorbutton21.setBackground(Background.fill(col));
        colorbutton22.setBackground(Background.fill(col));
        colorbutton23.setBackground(Background.fill(col));
        colorbutton24.setBackground(Background.fill(col));
        colorbutton25.setBackground(Background.fill(col));
        colorbutton26.setBackground(Background.fill(col));
        colorbutton27.setBackground(Background.fill(col));
        colorbutton28.setBackground(Background.fill(col));
        colorbutton29.setBackground(Background.fill(col));
        reset1.setBackground(Background.fill(col));
        reset2.setBackground(Background.fill(col));
        reset3.setBackground(Background.fill(col));
        reset4.setBackground(Background.fill(col));
        reset5.setBackground(Background.fill(col));
        reset6.setBackground(Background.fill(col));
        reset7.setBackground(Background.fill(col));
        reset8.setBackground(Background.fill(col));
        reset9.setBackground(Background.fill(col));
        reset10.setBackground(Background.fill(col));*/
    }

    @FXML//conditions de déclenchement du jeu
    void enclenchement(MouseEvent event) {
        if (declenchements) {
        }
    }


    //lancement du jeu, apparition de la zone de jeu
    @FXML
    void Go(MouseEvent event) {
        gamebackground1.setVisible(true);
        declenchements = true;
        regle1.setVisible(false);
        successimage.setVisible(false);
        defeatimage.setVisible(false);

        if (defeat && !bool) {
            if (!num1) {
                message.setText("Commencer");
                message1.setText("quand vous voulez");
            }
        } else if (!defeat && !win) {
            message.setText("C'est bien, " + nombreEssaies + " ième essaies");
            message1.setText("tu reussira peut-être cette fois !!!");
        }
        defeatimage.setVisible(false);
        successimage.setVisible(false);
        hiden();
    }

    //changement de couleur
    @FXML
    void validercouleur(MouseEvent event) throws InstantiationException, IllegalAccessException {
        Color col = couleur.getValue();
        String colchoice = (String) colorchoice.getSelectionModel().getSelectedItem();
        if (Objects.equals(colchoice, color1)) {
            message.setFill(col);
            message1.setFill(col);
            regle1.setFill(col);
        } else if (Objects.equals(colchoice, color2)) {
            colorbackground();
            //Tous ça parce que je n'ai pas pu donné le même ID aux bouttons invisibles

        } else if (Objects.equals(colchoice, color3)) {
            windowbackgroundcolor.setBackground(Background.fill(col));
        }
        colorchoice.setValue("Couleures"); //permet de rafficher "Couleures" même après l'appuie du button
    }

    // Zone des messages drôles
    @FXML
    void button7(MouseEvent event) {
        if (declenchements) {
            blocusshow1.setVisible(true);
            icones7.setVisible(true);
            String retourne = "Tu t'attendais à quoi !!!";
            message.setText(retourne);
            message1.setText("Retourne et prend le bon chemin");
            num1 = true;
        }
    }

    @FXML
    void button2(MouseEvent event) {
    }

    @FXML
    void button6(MouseEvent event) {
        if (declenchements) {
            if (num1) {
                message.setText("Voilà");
                message1.setText("Aller !!!");
            }
            boolean but7 = true;
        }
    }

    @FXML
    void button3(MouseEvent event) {
        if (declenchements && num1) {
            message1.setText("Toujours la facilité !");
        }
    }

    @FXML
    void button4(MouseEvent event) {
    }

    @FXML
    void button5(MouseEvent event) {
    }

    @FXML
    void button8(MouseEvent event) {
        if (declenchements) {
            blocusshow3.setVisible(true);
            icones8.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button9(MouseEvent event) {
        if (declenchements) {
            boolean but11 = true;
        }
    }

    @FXML
    void button10(MouseEvent event) {
        if (declenchements) {
            blocusshow4.setVisible(true);
            icones10.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button11(MouseEvent event) {
        if (declenchements) {
            blocusshow5.setVisible(true);
            icones11.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button12(MouseEvent event) {
        if (declenchements) {
            testArrive1 = true;
        }
    }

    @FXML
    void button13(MouseEvent event) {
        if (declenchements) {
            but14 = true;
        }
    }

    @FXML
    void button14(MouseEvent event) {
        if (declenchements && but14) {
            blocusshow6.setVisible(true);
            //icones21.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button15(MouseEvent event) {
        if (declenchements) {
            but16 = true;
        }
    }

    @FXML
    void button16(MouseEvent event) {
        if (declenchements && but16) {
            blocusshow7.setVisible(true);
            but17 = true;
            message.setText("Du courage");
            message1.setText("*********");
        }
    }

    @FXML
    void button17(MouseEvent event) {
        if (declenchements && but17) {
            blocusshow8.setVisible(true);
            icones10.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button18(MouseEvent event) {
    }

    @FXML
    void button19(MouseEvent event) {
        if (declenchements) {
            testArrive2 = true;
        }
    }

    @FXML
    void button20(MouseEvent event) {
        if (declenchements) {
            but21 = true;
        }
    }

    @FXML
    void button21(MouseEvent event) {
        if (declenchements && but21) {
            blocusshow9.setVisible(true);
            icones21.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button22(MouseEvent event) {
        if (declenchements) {
            but23 = true;
        }
    }

    @FXML
    void button23(MouseEvent event) {
        if (declenchements && but23) {
            blocusshow10.setVisible(true);
            icones21.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button24(MouseEvent event) {
        if (declenchements) {
            but25 = true;
            message.setText("Tiens bon...");
            message1.setText("Encore un p'tit éfort !!!");
        }
    }

    @FXML
    void button25(MouseEvent event) {
        if (declenchements && but25) {
            blocusshow2.setVisible(true);
            icones25.setVisible(true);
            message.setText("STOP !!!");
            message1.setText(stop1);
            booltext = true;
        }
    }

    @FXML
    void button26(MouseEvent event) {
    }

    @FXML
    void button27(MouseEvent event) {
        if (declenchements) {
            testArrive3 = true;
        }
    }

    @FXML
    void button28(MouseEvent event) {
        if (declenchements) {
            testArrive4 = true;
        }
    }

    @FXML
    void button29(MouseEvent event) {
    }

    @FXML
    void button1(MouseEvent event) {
        if (num1 && declenchements) {
            message.setText("C'est ça, vas-y, recommence !!!");
        }
    }

    @FXML
    void doNotTouch(MouseEvent event) {
        if (declenchements) {
            defeatimage.setVisible(true);
            defeat = false;
            message.setText("Mon gars...");
            message1.setText("T'as perdu !!!");
            nombreEssaies++;
            num1 = false;
            declenchements = false;
        }
    }

    @FXML
    void changetext(MouseEvent event) {
        if (declenchements) {
            if (booltext) {
                message.setText("COOL !");
                message1.setText("Continue ta route...");
            }
            booltext = false;
        }
    }

    private void hiden (){
        blocusshow1.setVisible(false);
        blocusshow2.setVisible(false);
        blocusshow3.setVisible(false);
        blocusshow4.setVisible(false);
        blocusshow5.setVisible(false);
        blocusshow6.setVisible(false);
        blocusshow7.setVisible(false);
        blocusshow8.setVisible(false);
        blocusshow9.setVisible(false);
        blocusshow10.setVisible(false);

        icones8.setVisible(false);
        icones7.setVisible(false);
        icones10.setVisible(false);
        icones21.setVisible(false);
        icones11.setVisible(false);
        icones25.setVisible(false);
    }

    @FXML
    void arrive(MouseEvent event) {
        if (declenchements && testArrive1 && testArrive2 && (testArrive3 || testArrive4) && defeat) {
            message.setText("COOL COOL COOL !!!");
            message1.setText("Belle victoire !!!");
            successimage.setVisible(true);
            win = true;
            num1 = false;
            nombreEssaies = 1;
            hiden();
            declenchements = false;
        } else if (declenchements && testArrive1 && testArrive2 && (testArrive3 || testArrive4)) {
            message.setText("Voilà !!!");
            message1.setText("Enfin, une victoire !!!");
            successimage.setVisible(true);
            win = true;
            num1 = false;
            nombreEssaies = 1;
            hiden();
            declenchements = false;
        }
    }

    @FXML
    void reinitialize(MouseEvent event) {

    }


    //Partie du deuxième jeu

    Random generator = new Random();
    int randomNumber, numberToTry;
    boolean relancer;
    String choice;

    @FXML
    private Text centerText;

    @FXML
    private Button lanceur;

    @FXML
    private Text leftBottomText;

    @FXML
    private Text leftTopText;

    @FXML
    private Text rightBottomText;

    @FXML
    private Text rightTopText;

    @FXML
    private ToggleGroup level;

    @FXML
    private RadioButton avancer;

    @FXML
    private RadioButton debutant;

    @FXML
    private RadioButton expert;

    @FXML
    private RadioButton interm;

    @FXML
    private Button levelchange;

    @FXML
    private VBox levelface;

    @FXML
    private HBox gamebackground2;

    @FXML
    private TextField devineMe;

    @FXML
    private ImageView doigtbas;

    @FXML
    private ImageView doigthaut;

    @FXML
    private ImageView game2img1;

    @FXML
    private ImageView game2img2;

    private void devinnette() {
        choice = devineMe.getText();

        if (Integer.parseInt(choice) < randomNumber) {
            doigthaut.setVisible(true);
            doigtbas.setVisible(false);
            devineMe.setText("");
        } else if (Integer.parseInt(choice) > randomNumber) {
            doigtbas.setVisible(true);
            doigthaut.setVisible(false);
            devineMe.setText("");
        } else {
            game2img1.setVisible(true);
            game2img2.setVisible(true);
            doigthaut.setVisible(false);
            doigtbas.setVisible(false);
            message.setText("Excelent, après " + numberToTry + " essaies,");
            message1.setText("Vous avez finalement trouver le nombre!");
        }
        numberToTry++ ;
        if (numberToTry >= 2) {
            lanceur.setText("Relancer");
        }
    }

    @FXML
    void validerNiveau2(MouseEvent event) {
    }

    @FXML
    void levelchange2(MouseEvent event) {
        gamebackground2.setVisible(false);
        levelface.setVisible(true);
    }

    @FXML
    void lanceur2(MouseEvent event) {
        if (level.getSelectedToggle().equals(debutant)) {
            randomNumber = generator.nextInt(100);
            levelchange.setText("0 à 100");
        } else if (level.getSelectedToggle().equals(interm)) {
            randomNumber = generator.nextInt(500);
            levelchange.setText("0 à 500");
        } else if (level.getSelectedToggle().equals(avancer)) {
            randomNumber = generator.nextInt(1000);
            levelchange.setText("0 à 1000");
        } else if (level.getSelectedToggle().equals(expert)) {
            randomNumber = generator.nextInt(10000);
            levelchange.setText("0 à 10000");
        }
        regle2.setVisible(false);
        gamebackground2.setVisible(true);
        levelface.setVisible(false);
        centerText.setText(String.valueOf(numberToTry = 1) + " essaies(es)");
        game2img1.setVisible(false);
        game2img2.setVisible(false);
        message1.setText("Commencez à jouer");
    }

    @FXML
    void game1(MouseEvent event) {
        commencer.setVisible(true);
        message.setText("PARCOURS DE LA SOURIS " + username);
        message1.setText("Amusez-vous ...");
        regle1.setVisible(true);
        lanceur.setVisible(false);
        regle2.setVisible(false);
        game2img1.setVisible(false);
        game2img2.setVisible(false);
    }

    @FXML
    void game2(MouseEvent event) {
        message.setText("DEVINE MOI");
        message1.setText("Amusez-vous ...");
        regle2.setVisible(true);
        gamebackground1.setVisible(false);
        commencer.setVisible(false);
        lanceur.setVisible(true);
        regle1.setVisible(false);
        successimage.setVisible(false);
        defeatimage.setVisible(false);
    }

    @FXML
    void reelvalide(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            devinnette();
            centerText.setText(String.valueOf(numberToTry) + " essaies(es)");
        }
    }

    @FXML
    void validenumber(MouseEvent event) {
        devinnette();
        centerText.setText(String.valueOf(numberToTry) + " essaies(es)");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        randomNumber = generator.nextInt(100);
        Color col = couleur.getValue();
        Stage stage = (Stage) message.getScene().getWindow();
        message.setText("Bienvenue dans le jeu d'Ahmad" + stage.getUserData());
        message1.setText("Commencez à jouer");

        colorchoice.setValue("Couleures");
        colorchoice.getItems().addAll(color1, color2, color3);
    }
}