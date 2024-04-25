package vue;

import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import modele.DateCalendrier;
import org.controlsfx.control.spreadsheet.Grid;

public class GridPaneFormulaireReservation extends GridPane {

    TextField textFieldCours;
    ToggleGroup levelGroup = new ToggleGroup();
    ComboBox<String> comboHd;
    ComboBox<String> comboHf;
    ComboBox<String> comboMnD;
    ComboBox<String> comboMnF;

    public GridPaneFormulaireReservation() {

        this.setPadding(new Insets(5));

        this.setHgap(9);
        this.setVgap(14);
        this.setGridLinesVisible(false);
        int ligne = 0;

        DateCalendrier today = new DateCalendrier();

        Label labelDate = new Label(today.toString());
        labelDate.setPadding(new Insets(2));
        labelDate.setId("date");

        Label labelCours = new Label("Cours ");
        labelCours.setMnemonicParsing(true);
        labelCours.setPadding(new Insets(1));

        Label labelheuredebut = new Label("Heure de ");

        Label label_h = new Label("h");

        Label label_mn = new Label("mn");

        Label label_a = new Label("a");

        Label label_h_fi = new Label("h");

        Label label_mn_fi = new Label("mn");

        Label label_nv = new Label("Niveau ");

        ComboBox<String> comboHeureDebut = new ComboBox<>();
        comboHeureDebut.getItems().addAll("07", "08", "09", "10", "11", "13", "14", "15");
        comboHeureDebut.setValue("07");

        ComboBox<String> comboMinuteDebut = new ComboBox<>();
        comboMinuteDebut.getItems().addAll("00", "15", "30", "45");
        comboMinuteDebut.setValue("00");

        ComboBox<String> comboHeureFin = new ComboBox<>();
        comboHeureFin.getItems().addAll("07", "08", "09", "10", "11", "13", "14", "15");
        comboHeureFin.setValue("10");

        ComboBox<String> comboMinuteFin = new ComboBox<>();
        comboMinuteFin.getItems().addAll("00", "15", "30", "45");
        comboMinuteFin.setValue("30");

        // Bouton d'enregistrement/D'annulement
        Button boutonAnnul = new Button("Annuler");
        Button boutonEnreg = new Button("Enregistrer");


        ToggleGroup groupeNiveau = new ToggleGroup();
        RadioButton boutonDebutant = new RadioButton("débutant");
        boutonDebutant.setSelected(true);
        boutonDebutant.setToggleGroup(groupeNiveau);
        RadioButton boutonMoyen = new RadioButton("moyen");
        boutonMoyen.setToggleGroup(groupeNiveau);
        RadioButton boutonDur = new RadioButton("difficile");
        boutonDur.setToggleGroup(groupeNiveau);
        RadioButton boutonExpert = new RadioButton("expert");
        boutonExpert.setToggleGroup(groupeNiveau);


        Separator separateur = new Separator();

        TextField text_cours = new TextField();
        text_cours.setPrefHeight(3);

        Platform.runLater(() -> text_cours.requestFocus());

        this.add(labelDate, 1, ligne++, 6, 1);
        this.add(labelCours, 0, ligne, 1, 1);
        this.add(text_cours, 1, ligne++, 5, 1);
        this.add(labelheuredebut, 0, ligne, 1, 1);
        this.add(comboHeureDebut, 1, ligne, 1, 1);
        this.add(label_h, 2, ligne, 1, 1);
        this.add(comboMinuteDebut, 3, ligne, 1, 1);
        this.add(label_mn, 4, ligne++, 1, 1);
        this.add(label_a, 0, ligne, 1, 1);
        this.add(comboHeureFin, 1, ligne, 1, 1);
        this.add(label_h_fi, 2, ligne, 1, 1);
        this.add(comboMinuteFin, 3, ligne, 1, 1);
        this.add(label_mn_fi, 4, ligne++, 1, 1);

        this.add(label_nv, 0, ligne, 1, 1);
        this.add(boutonDebutant, 1, ligne, 1, 1);
        this.add(boutonMoyen, 2, ligne++, 1, 1);
        this.add(boutonDur, 1, ligne, 1, 1);
        this.add(boutonExpert, 2, ligne++, 1, 1);

        this.add(boutonEnreg, 1, ligne, 1, 1);
        this.add(boutonAnnul, 2, ligne, 1, 1);
    }
}
