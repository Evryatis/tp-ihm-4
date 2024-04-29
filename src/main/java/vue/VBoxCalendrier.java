package vue;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

public class VBoxCalendrier extends VBox implements ConstantesCalendrier {
    public VBoxCalendrier() {
        // Garder le format des TilePanes
        this.setFillWidth(false);

        StackPane stackPaneMois = new StackPane();

        DateCalendrier today = new DateCalendrier();

        ToggleGroup buttonGroup = new ToggleGroup();

        // Label avec le mois courant en haut du calendrier
        Label currentMonth = new Label(MOIS[today.getMois() - 1] + " " + Integer.toString(today.getAnnee()));
        currentMonth.setId("currentMonth");

        // Ajout de chaque date de chaque mois au StackPane
        for (int i = 1; i <= 12; i++) {
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i, today.getAnnee());

            // Grille de composants (1 par mois)
            TilePane tilePane = new TilePane();

            // Préférer 7 colonnes (1 colonne par jour)
            tilePane.setPrefColumns(7);
            // Préférer un nombre de lignes égal au nombre de jours + 1 ligne pour les noms de jours
            tilePane.setPrefRows((monthCalendar.getDates().size() / 7) + 1);

            tilePane.setId("opaque");

            // Ajout des noms de jours abrégés en premier
            for (String jourAb : JOURS_SEMAINE_ABR) {
                Label labelJour = new Label(jourAb);
                tilePane.getChildren().add(labelJour);
            }

            // Ajout des boutons pour chaque date
            for (DateCalendrier date : monthCalendar.getDates()) {
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);

                boutonDate.setOnAction(HBoxRoot.getControleur());

                /*
                boutonDate.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        System.out.println(boutonDate.getUserData());
                    }
                });
                */


                if (date.getMois() != monthCalendar.getMois()) {
                    boutonDate.setId("dateHorsMois");
                }

                if (date.isToday()) {
                    boutonDate.setId("today");
                }
            }

            tilePane.setAccessibleText(MOIS[i - 1]);
            stackPaneMois.getChildren().add(tilePane);
        }

        // Affichage des jours du mois de la date d'aujourd'hui
        List<Node> listMonthCalendars = stackPaneMois.getChildren();
        final int LAST_INDICE = listMonthCalendars.size() - 1;
        // Node premierMois = listMonthCalendars.get(0);
        // Node dernierMois = listMonthCalendars.get(LAST_INDICE);

        while (!listMonthCalendars.get(LAST_INDICE).getAccessibleText().equals(MOIS[today.getMois() - 1])) {
            listMonthCalendars.get(LAST_INDICE).toBack();
        }



        // Création des boutons de navigation
        HBox buttonHBox = new HBox();

        Button previousButton = new Button("<");
        previousButton.setId("navigationButtons");
        Button nextButton = new Button(">");
        nextButton.setId("navigationButtons");

        previousButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentMonth.setText(listMonthCalendars.get(LAST_INDICE - 1).getAccessibleText() + " " + Integer.toString(today.getAnnee()));
                listMonthCalendars.get(LAST_INDICE).toBack();
            }
        });

        nextButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currentMonth.setText(listMonthCalendars.get(0).getAccessibleText() + " " + Integer.toString(today.getAnnee()));
                listMonthCalendars.get(0).toFront();
            }
        });

        buttonHBox.getChildren().addAll(previousButton, nextButton);

        VBox.setMargin(currentMonth, new Insets(10));
        VBox.setMargin(buttonHBox, new Insets(10));
        this.getChildren().addAll(currentMonth, stackPaneMois, buttonHBox);
    }
}