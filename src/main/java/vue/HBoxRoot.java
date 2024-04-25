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

        calendrierPane = new VBoxCalendrier();
        reservationPane = new GridPaneFormulaireReservation();
        controleur = new Controleur();
        planning = new PlanningCollections();


        VBoxCalendrier VBoxCal = new VBoxCalendrier();
        this.getChildren().add(VBoxCal);

        // Commencement du TP4
        GridPaneFormulaireReservation gridPaneForm = new GridPaneFormulaireReservation();
        this.getChildren().add(gridPaneForm);

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
