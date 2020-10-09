
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
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Producto;

import javax.swing.*;


public class InicioController implements Initializable {

    public MenuItem Mnreporte;
    public MenuItem Mnproductos;
    public MenuItem Mnorden;
    public MenuItem Mnproductosr;
    public MenuItem Mnordenr;
    @FXML
    private Button btnCliente;
    @FXML
    private Button btnProducto;
    @FXML
    private Button btnOrden;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    @FXML
    private void gestionCliente(ActionEvent event) {
        
        
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
                Parent root = loader.load();
                ClienteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
                System.out.println("-----------------------------------------");
                for(Producto producto: SesionController.productos){
                    System.out.println(producto.toString());
                }
         }catch(IOException e){
             
         }
    }

    @FXML
    private void gestioProducto(ActionEvent event) {
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductoVista.fxml"));
                Parent root = loader.load();
                ProductoController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
         }catch(IOException e){
         }
    }

    @FXML
    private void gestionOrden(ActionEvent event) {
        try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OrdenVista.fxml"));
                Parent root = loader.load();
                OrdenController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                for(Cliente cliente: SesionController.clientes){
                    System.out.println(cliente.toString());
                }
         }catch(IOException e){
         }
    }

    @FXML
    public void gestionSalir(ActionEvent event) {
          try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/SesionVista.fxml"));
                Parent root = loader.load();
                SesionController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
         }catch(IOException e){
             
         }
    }
    
    public void closeWindows(){
        
    }

    public void MnEmpresa(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EmpVista.fxml"));
            Parent root = loader.load();
            EmpController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
        } catch (IOException e) {

        }
    }

    public void Mncliente(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/IndVista.fxml"));
            Parent root = loader.load();
            IndController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
        } catch (IOException e) {
        }
    }


    public void Mnreporte(ActionEvent actionEvent) {
        int seleccion = JOptionPane.showOptionDialog(null, "Como desea ver el Reporte:",
                "Reporte Tipo Cliente", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Empresa", "Individual", "Todos"}, "EMPRESA");
        if (seleccion == 0) {
            SesionController.tipoConsulta = "Empresa";
        }
        if (seleccion == 1) {
            SesionController.tipoConsulta = "Individual";
        }
        if (seleccion == 2) {
            SesionController.tipoConsulta = "Consolidado";
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
            } catch (IOException e) {

            }
        }
    }

    public void Mnproductos(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductoVista.fxml"));
            Parent root = loader.load();
            ProductoController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
        } catch (IOException e) {
        }
    }

    public void Mnorden(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/OrdenVista.fxml"));
            Parent root = loader.load();
            OrdenController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
        } catch (IOException e) {
        }
    }

    public void Mnproductosr(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridProductoVista.fxml"));
            Parent root = loader.load();
            GridProductoController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());

        }catch(IOException e){
        }
    }

    public void Mnordenr(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridOrdenVista.fxml"));
            Parent root = loader.load();
            GridOrdenController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            for(Cliente cliente: SesionController.clientes){
                System.out.println(cliente.toString());
            }
        }catch(IOException e){
        }
    }
}
