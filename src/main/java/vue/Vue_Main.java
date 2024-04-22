package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;


public class Vue_Main extends Application {
    // Une seule méthode start
    public void start(Stage stage) {
        // Crée une instance de VBoxRoot
        // VBoxCalendrier root = new VBoxCalendrier();
        HBoxRoot root  = new HBoxRoot();
        Scene scene = new Scene(root, 800, 400);
        File css = new File("css" + File.separator + "css.css");
        scene.getStylesheets().add(css.toURI().toString());
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
    }

    // Une seule méthode main
    public static void main(String[] args) {
        Application.launch(args);
    }
}
