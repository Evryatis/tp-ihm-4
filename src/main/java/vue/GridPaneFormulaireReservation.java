package vue;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;
import modele.Horaire;

public class GridPaneFormulaireReservation extends GridPane {

    public TextField textFieldCours;
    public Label labelDate;
    public DateCalendrier date;
    public ToggleGroup levelGroup = new ToggleGroup();
    public ComboBox<String> comboHd;
    public ComboBox<String> comboHf;
    public ComboBox<String> comboMnD;
    public ComboBox<String> comboMnF;

    public GridPaneFormulaireReservation() {

        this.setPadding(new Insets(5));

        this.setHgap(9);
        this.setVgap(14);
        this.setGridLinesVisible(false);
        int ligne = 0;


        date = new DateCalendrier();
        labelDate = new Label();
        comboHd = new ComboBox<>();
        comboHf = new ComboBox<>();
        comboMnD = new ComboBox<>();
        comboMnF = new ComboBox<>();

        labelDate = new Label(date.toString());
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


        comboHd.getItems().addAll("07", "08", "09", "10", "11", "12", "13", "14", "15");
        comboHd.setValue("07");


        comboMnD.getItems().addAll("00", "15", "30", "45");
        comboMnD.setValue("00");


        comboHf.getItems().addAll("07", "08", "09", "10", "11", "12", "13", "14", "15");
        comboHf.setValue("10");


        comboMnF.getItems().addAll("00", "15", "30", "45");
        comboMnF.setValue("30");

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

        textFieldCours = new TextField();
        textFieldCours.setPrefHeight(3);

        Platform.runLater(textFieldCours::requestFocus);

        this.add(labelDate, 1, ligne++, 6, 1);
        this.add(labelCours, 0, ligne, 1, 1);
        this.add(textFieldCours, 1, ligne++, 5, 1);
        this.add(labelheuredebut, 0, ligne, 1, 1);
        this.add(comboHd, 1, ligne, 1, 1);
        this.add(label_h, 2, ligne, 1, 1);
        this.add(comboMnD, 3, ligne, 1, 1);
        this.add(label_mn, 4, ligne++, 1, 1);
        this.add(label_a, 0, ligne, 1, 1);
        this.add(comboHf, 1, ligne, 1, 1);
        this.add(label_h_fi, 2, ligne, 1, 1);
        this.add(comboMnF, 3, ligne, 1, 1);
        this.add(label_mn_fi, 4, ligne++, 1, 1);

        this.add(label_nv, 0, ligne, 1, 1);
        this.add(boutonDebutant, 1, ligne, 1, 1);
        this.add(boutonMoyen, 2, ligne++, 1, 1);
        this.add(boutonDur, 1, ligne, 1, 1);
        this.add(boutonExpert, 2, ligne++, 1, 1);

        boutonEnreg.setOnAction(HBoxRoot.getControleur());
        boutonAnnul.setOnAction(HBoxRoot.getControleur());
        comboHd.setOnAction(HBoxRoot.getControleur());
        comboHf.setOnAction(HBoxRoot.getControleur());
        comboMnD.setOnAction(HBoxRoot.getControleur());
        comboMnF.setOnAction(HBoxRoot.getControleur());

        this.add(boutonEnreg, 1, ligne, 1, 1);
        this.add(boutonAnnul, 2, ligne, 1, 1);
    }

    public void update(DateCalendrier date_a_modif) {
        this.date = date_a_modif;
        labelDate.setText(date.toString());

    }

    public String getTextFieldCours() {
        return this.textFieldCours.getText();
    }

    public DateCalendrier getDate() {
        return this.date;
    }

    public Horaire getHoraireDebut() {
        return new Horaire(this.comboHd.getSelectionModel().getSelectedIndex() + 7,
                this.comboMnD.getSelectionModel().getSelectedIndex() * 15);
    }

    public Horaire getHoraireFin(){
        return new Horaire(this.comboHf.getSelectionModel().getSelectedIndex() + 7,
                this.comboMnF.getSelectionModel().getSelectedIndex() * 15);
    }

    public void annuler(){
        textFieldCours.setText(" ");
        comboHd.setValue("07");
        comboMnD.setValue("00");
        comboHf.setValue("10");
        comboMnF.setValue("30");
    }


    // handle String cours = HboxRoot.getFormulaire().getTextFieldCours();
}
