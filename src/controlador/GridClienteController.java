package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Individual;

public class GridClienteController implements Initializable {
    @FXML
    private Button btnRegresar;
    @FXML
    private GridPane grid;
    private JFXPanel btnAtras;

    /**
     * Inicializando controlador.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if(SesionController.tipoConsulta.equals("empresa")){
     cargarDatosEmpresas();
        }else{
            if(SesionController.tipoConsulta.equals("individual")){
                cargarDatosIndividual();
            }else{
                cargarDatos();
            }
        }
    }    

    public void closeWindows(){
    }

    public void cargarDatosEmpresas() {
        int f=0;
        int c=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("Empresa: ");
         Text esp0 = new Text("_________________");
         grid.add(ini, c, f);
         grid.add(esp0, c, 1);
        f=2;
        for (Cliente e : SesionController.clientes) {
            if (e.getTipoCliente().equals("empresa")) {
                
                
                Empresa empresa = (Empresa) e;
                
                Text tipoC = new Text("Tipo Cliente: ");
                Text txtTipo = new Text("Empresa");
                grid.add(tipoC, c, f);
                c++;
                grid.add(txtTipo, c, f);
                
                
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(empresa.getId()));
                c=0;
                f++;
                grid.add(id, c, f);
                c++;
                grid.add(txtId, c, f);
                
                Text nombreC = new Text("Nombre: ");
                Text txtNombre = new Text(empresa.getNombre());
                c=0;
                f++;
                grid.add(nombreC, c, f);
                c++;
                grid.add(txtNombre, c, f);
                
                Text direccion = new Text("Direccion: ");
                Text txtDireccion = new Text(empresa.getDireccion());
                c=0;
                f++;
                grid.add(direccion, c, f);
                c++;
                grid.add(txtDireccion, c, f);
                
                Text telefono = new Text("Telefono: ");
                Text txtTelefono = new Text(empresa.getTelefono());
                c=0;
                f++;
                grid.add(telefono, c, f);
                c++;
                grid.add(txtTelefono, c, f);
                
                Text contacto = new Text("Contacto: ");
                Text txtContacto = new Text(empresa.getContacto());
                c=0;
                f++;
                grid.add(contacto, c, f);
                c++;
                grid.add(txtContacto, c, f);
                
                Text descuento = new Text("Descuento: ");
                Text txtDescuento = new Text(String.valueOf(empresa.getDescuento()));
                c=0;
                f++;
                grid.add(descuento, c, f);
                c++;
                grid.add(txtDescuento, c, f);
                
               Text esp1 = new Text("_________________");
                c=0;
                f++;
                grid.add(esp1, c, f);
            }
        }
    }
    
    public void cargarDatosIndividual() {
        int f=0;
        int c=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("Individual: ");
         Text esp0 = new Text("_________________");
         grid.add(ini, c, f);
         grid.add(esp0, c, 1);
        f=2;
        for (Cliente i : SesionController.clientes) {
            if (i.getTipoCliente().equals("individual")) {

                Individual indi = (Individual) i;
                Text tipoC = new Text("Tipo Cliente: ");
                Text txtTipo = new Text("Individual");
                grid.add(tipoC, c, f);
                c++;
                grid.add(txtTipo, c, f);

                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(indi.getId()));
                c=0;
                f++;
                grid.add(id, c, f);
                c++;
                grid.add(txtId, c, f);
                
                Text nombreC = new Text("Nombre: ");
                Text txtNombre = new Text(indi.getNombre());
                c=0;
                f++;
                grid.add(nombreC, c, f);
                c++;
                grid.add(txtNombre, c, f);
                
                Text direccion = new Text("Direccion: ");
                Text txtDireccion = new Text(indi.getDireccion());
                c=0;
                f++;
                grid.add(direccion, c, f);
                c++;
                grid.add(txtDireccion, c, f);
                
                Text telefono = new Text("Telefono: ");
                Text txtTelefono = new Text(indi.getTelefono());
                c=0;
                f++;
                grid.add(telefono, c, f);
                c++;
                grid.add(txtTelefono, c, f);
                
                Text dpi = new Text("DPI: ");
                Text txtDpi = new Text(indi.getDPI());
                c=0;
                f++;
                grid.add(dpi, c, f);
                c++;
                grid.add(txtDpi, c, f);
                Text esp1 = new Text("_________________");
                c=0;
                f++;
                grid.add(esp1, c, f);
            }
        }
    }

    private void cargarDatos() {
        
        int f=0;
        int c=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("Clientes Unificado: ");
         Text esp0 = new Text("_________________");
         grid.add(ini, c, f);
         grid.add(esp0, c, 1);
        f=2;
        for (Cliente i : SesionController.clientes) {
            if (i.getTipoCliente().equals("individual")) {
                Individual indi = (Individual) i;
                Text tipoC = new Text("Tipo Cliente: ");
                Text txtTipo = new Text("Individual");
                grid.add(tipoC, c, f);
                c++;
                grid.add(txtTipo, c, f);
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(indi.getId()));
                c=0;
                f++;
                grid.add(id, c, f);
                c++;
                grid.add(txtId, c, f);
                
                Text nombreC = new Text("Nombre: ");
                Text txtNombre = new Text(indi.getNombre());
                c=0;
                f++;
                grid.add(nombreC, c, f);
                c++;
                grid.add(txtNombre, c, f);
                
                Text direccion = new Text("Direccion: ");
                Text txtDireccion = new Text(indi.getDireccion());
                c=0;
                f++;
                grid.add(direccion, c, f);
                c++;
                grid.add(txtDireccion, c, f);
                
                Text telefono = new Text("Telefono: ");
                Text txtTelefono = new Text(indi.getTelefono());
                c=0;
                f++;
                grid.add(telefono, c, f);
                c++;
                grid.add(txtTelefono, c, f);
                
                Text dpi = new Text("DPI: ");
                Text txtDpi = new Text(indi.getDPI());
                c=0;
                f++;
                grid.add(dpi, c, f);
                c++;
                grid.add(txtDpi, c, f);
                Text esp1 = new Text("_________________");
                c=0;
                f++;
                grid.add(esp1, c, f);
            }else{

                Empresa empresa = (Empresa) i;
                Text tipoC = new Text("Tipo Cliente: ");
                Text txtTipo = new Text("Empresa");
                grid.add(tipoC, c, f);
                c++;

                grid.add(txtTipo, c, f);
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(empresa.getId()));
                c=0;
                f++;
                grid.add(id, c, f);
                c++;
                grid.add(txtId, c, f);
                
                Text nombreC = new Text("Nombre: ");
                Text txtNombre = new Text(empresa.getNombre());
                c=0;
                f++;
                grid.add(nombreC, c, f);
                c++;
                grid.add(txtNombre, c, f);
                
                Text direccion = new Text("Direccion: ");
                Text txtDireccion = new Text(empresa.getDireccion());
                c=0;
                f++;
                grid.add(direccion, c, f);
                c++;
                grid.add(txtDireccion, c, f);
                
                Text telefono = new Text("Telefono: ");
                Text txtTelefono = new Text(empresa.getTelefono());
                c=0;
                f++;
                grid.add(telefono, c, f);
                c++;
                grid.add(txtTelefono, c, f);
                
                Text contacto = new Text("Contacto: ");
                Text txtContacto = new Text(empresa.getContacto());
                c=0;
                f++;
                grid.add(contacto, c, f);
                c++;
                grid.add(txtContacto, c, f);
                
                Text descuento = new Text("Descuento: ");
                Text txtDescuento = new Text(String.valueOf(empresa.getDescuento()));
                c=0;
                f++;
                grid.add(descuento, c, f);
                c++;
                grid.add(txtDescuento, c, f);
                
               Text esp1 = new Text("_________________");
                c=0;
                f++;
                grid.add(esp1, c, f);
                
            }
        }






    }
    
}
