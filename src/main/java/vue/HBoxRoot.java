package vue;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HBoxRoot extends HBox {

    public HBoxRoot(){

        VBoxCalendrier VBoxCal = new VBoxCalendrier();
        this.getChildren().add(VBoxCal);

        // Commencement du TP4
        GridPaneFormulaireReservation gridPaneForm = new GridPaneFormulaireReservation();
        this.getChildren().add(gridPaneForm);

    }
}
