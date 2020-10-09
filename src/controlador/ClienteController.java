package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ClienteController implements Initializable {

    private Button btnRegistrar;
    @FXML
    private Button btnAtras;
    @FXML
    private Button btnEmpresas;
    @FXML
    private Button btnIndividual;
    @FXML
    private Button btnconsultar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void closeWindows() {
    }


    @FXML
    private void gEmpresas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EmpVista.fxml"));
            Parent root = loader.load();
            EmpController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            //Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            //myStage.close();
        } catch (IOException e) {

        }
    }

    @FXML
    private void gIndividual(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/IndVista.fxml"));
            Parent root = loader.load();
            IndController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            //Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
            //myStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void consultar(ActionEvent event) {
        int seleccion = JOptionPane.showOptionDialog(null, "CONSULTAR POR..",
                "TIPO CLIENTE", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"EMPRESA", "INDIVIDUAL", "TODOS"}, "EMPRESA");
        if (seleccion == 0) {
            SesionController.tipoConsulta = "empresa";
        }
        if (seleccion == 1) {
            SesionController.tipoConsulta = "individual";
        }
        if (seleccion == 2) {
            SesionController.tipoConsulta = "todos";
        }
        if (seleccion != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridClienteVista.fxml"));
                Parent root = loader.load();
                GridClienteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                //Stage myStage = (Stage) this.btnAtras.getScene().getWindow();
                //myStage.close();
            } catch (IOException e) {

            }
        }
    }
}
