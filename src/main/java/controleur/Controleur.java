package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import modele.*;
import vue.GridPaneFormulaireReservation;
import vue.HBoxRoot;
import vue.VBoxCalendrier;

public class Controleur implements EventHandler {

    @Override
    public void handle(Event event) {

        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPaneDef = HBoxRoot.getReservationPane();

        // la source de event est un ToggleButton du calendrier
        if (event.getSource() instanceof ToggleButton) {
            System.out.println("Date Cliquée");
            ToggleButton toggle = (ToggleButton)event.getSource();
            DateCalendrier date = (DateCalendrier)toggle.getUserData();
            System.out.println(date);
            HBoxRoot.getReservationPane().update(date);


        }

        if (event.getSource() instanceof RadioButton) {
            RadioButton selection = (RadioButton)event.getSource();
            System.out.println("Bouton aux cliqué!");

        }

        // la source de event est le bouton "Enregistrer" du formulaire de réservation
        if (event.getSource() instanceof Button) {
            System.out.println("Bouton cliqué!");
            if (((Button) event.getSource()).getText().equals("Enregistrer")){
                String intitule = String.valueOf(reservationPaneDef.getTextFieldCours());
                Date date_reserv = reservationPaneDef.getDate();
                Horaire horaireDebut = reservationPaneDef.getHoraireDebut();
                Horaire horaireFin = reservationPaneDef.getHoraireFin();

                System.out.println(intitule + " " +date_reserv + " " + horaireDebut + " " + horaireFin);
                Reservation nouv_reserv;
                nouv_reserv = new Reservation(date_reserv, horaireDebut, horaireFin, intitule);
                System.out.println(nouv_reserv);
            }


        }
    }
}