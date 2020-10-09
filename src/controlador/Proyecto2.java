
package controlador;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Proyecto2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
         try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Proyecto2.class.getResource("/vista/SesionVista.fxml"));
            Pane ventana = (Pane) loader.load();
            Scene   scene  = new  Scene(ventana);
            primaryStage.setTitle("Proyecto II Programación II");
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e){
            System.out.print(e.getMessage());
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
