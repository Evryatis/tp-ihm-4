package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.PlanningCollections;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;
import vue.VBoxCalendrier;

public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {

        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        // la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            System.out.println("Date Cliquée");


        }

        // la source de event est le bouton "Enregistrer" du formulaire de réservation
        if (event.getSource() instanceof Button) {
            // à compléter question 6
        }
    }
}