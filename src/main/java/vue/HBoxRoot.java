package vue;

import controleur.Controleur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.PlanningCollections;

public class HBoxRoot extends HBox {

    private static PlanningCollections planning ;
    private static Controleur controleur ;
    private static VBoxCalendrier calendrierPane ;
    private static GridPaneFormulaireReservation reservationPane ;

    public HBoxRoot(){

        planning = new PlanningCollections();
        controleur = new Controleur();
        calendrierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();



        VBoxCalendrier VBoxCal = new VBoxCalendrier();
        this.getChildren().add(VBoxCal);

        // Commencement du TP4
        this.getChildren().add(reservationPane);

    }


    public static GridPaneFormulaireReservation getReservationPane() {
        return reservationPane;
    }

    public static void setReservationPane(GridPaneFormulaireReservation reservationPane) {
        HBoxRoot.reservationPane = reservationPane;
    }

    public static VBoxCalendrier getCalendrierPane() {
        return calendrierPane;
    }

    public static void setCalendrierPane(VBoxCalendrier calendrierPane) {
        HBoxRoot.calendrierPane = calendrierPane;
    }

    public static Controleur getControleur() {
        return controleur;
    }

    public static void setControleur(Controleur controleur) {
        HBoxRoot.controleur = controleur;
    }

    public static PlanningCollections getPlanning() {
        return planning;
    }

    public static void setPlanning(PlanningCollections planning) {
        HBoxRoot.planning = planning;
    }
}
