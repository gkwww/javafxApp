/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chart.tabledatasample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author afelipelc
 */
public class TableDataSample extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
        
        Scene scene = new Scene(root, 1100, 600);
        stage.setTitle("Lista de Vacantes en TI");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The fxml() method is ignored in correctly deployed JavaFX application.
     * fxml() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores fxml().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}