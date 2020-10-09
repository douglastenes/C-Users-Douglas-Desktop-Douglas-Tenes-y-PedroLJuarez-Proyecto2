package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Orden;
import modelo.Producto;
import modelo.Usuario;
import otros.DataSistema;


public class SesionController implements Initializable {
    
    
    public static List<Cliente> clientes;
    public static List<Producto> productos;
    public static List<Orden> ordenes;
    public static String tipoConsulta;
    

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button txtLogin;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DataSistema.cargarDatosUsuarios();
        DataSistema.cargarDatosProductos();
        DataSistema.cargarDatosClientes();
        DataSistema.cargarDatosOrdenes();
        
        clientes = new ArrayList();
        for (Cliente c : DataSistema.clientesA) {
            clientes.add(c);
        }
        productos = new ArrayList();
        for (Producto p : DataSistema.productosA) {
            productos.add(p);
        }
        ordenes = new ArrayList();
        for (Orden o : DataSistema.ordenesA) {
            ordenes.add(o);
        }
    }

    @FXML
    private void login(ActionEvent event) {
        boolean valida = false;
        // se recorre la lista para validar si el usuario y contraseña son correctas
        for (Usuario user : DataSistema.usuarios) {
            if ((user.getUsuario().equals(txtUser.getText())) && (user.getClave().equals(txtPassword.getText()))) {
                valida = true;
                break;
            }
        }
        if (valida == true) {
             try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
                Parent root = loader.load();
                InicioController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
         }catch(IOException e){
             
         }
        } else {
            JOptionPane.showMessageDialog(null, "DATOS NO VALIDOS", "INICIO SESION", JOptionPane.INFORMATION_MESSAGE);
            txtPassword.setText("");
            txtUser.setText("");
        }

    }


    public void btcerrar(ActionEvent actionEvent) {System.exit(0);
    }
}
