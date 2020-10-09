package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Individual;

public class IndController implements Initializable {

    @FXML
    private Button btnAtras;
    @FXML
    private Button btnRegistrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDpi;
    @FXML
    private TableView<Individual> tabla;
    @FXML
    private TableColumn<Individual, Integer> colId;
    @FXML
    private TableColumn<Individual, String> colNombre;
    @FXML
    private TableColumn<Individual, String> colTelefono;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableColumn<Individual, String> colDpi;
    @FXML
    private TableColumn<Individual, String> colDireccion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarIndividuales();
    }    

    
    @FXML
    private void gestionRegistrar(ActionEvent event) {
        try {
            Individual individual = new Individual(txtDpi.getText(), txtNombre.getText(),
                    txtDireccion.getText(), txtTelefono.getText(), "individual");
            SesionController.clientes.add(individual);
            JOptionPane.showMessageDialog(null, "Nuevo dato Agregado", "Creado", JOptionPane.INFORMATION_MESSAGE);
            mostrarIndividuales();
            limpiarCampos();
        } catch (HeadlessException e) {
           JOptionPane.showMessageDialog(null, "Datos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }

    }
    
    @FXML
    private void actualizar(ActionEvent event) {
         int posicion = 0;
        try {
            Individual individual = new Individual(txtDpi.getText(), txtNombre.getText(),
                    txtDireccion.getText(), txtTelefono.getText(), "individual");
            for (Cliente cliente : SesionController.clientes) {
                if (Integer.parseInt(txtId.getText()) == cliente.getId()) {
                    posicion = SesionController.clientes.indexOf(cliente);
                    break;
                }
            }
            individual.setId(Integer.parseInt(txtId.getText()));
            SesionController.clientes.set(posicion, individual);
            Cliente.sigIdCliente--;
            JOptionPane.showMessageDialog(null, "Registro Modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
            mostrarIndividuales();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se logro Modificar", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

     @FXML
    private void eliminar(ActionEvent event) {
        int posicion = 0;
        try {
            for (Cliente c : SesionController.clientes) {
                if (Integer.parseInt(txtId.getText()) == c.getId()) {
                    posicion = SesionController.clientes.indexOf(c);
                    break;
                }
            }
            SesionController.clientes.remove(posicion);
            JOptionPane.showMessageDialog(null, "Eliminar Dato", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
            mostrarIndividuales();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Imposible, Borrar el Registro", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }
    
    
    public ObservableList<Individual> getIndividuales(){
        ObservableList<Individual> listaIndi = FXCollections.observableArrayList();
        for(Cliente c: SesionController.clientes){
            if(c.getTipoCliente().equals("individual")){
                Individual i = (Individual) c;
                 listaIndi.add(i);
            }
           
            }
        return listaIndi;
    }
    
    public void mostrarIndividuales(){
        ObservableList<Individual> list = getIndividuales();
        colId.setCellValueFactory(new PropertyValueFactory<>("id") );
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDpi.setCellValueFactory(new PropertyValueFactory<>("DPI"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla.setItems(list);
    }

    public void closeWindows(){

    }

    @FXML
    private void click(MouseEvent event) {
        Individual ind = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(ind.getId()));
        txtNombre.setText(ind.getNombre());
        txtDireccion.setText(ind.getDireccion());
        txtTelefono.setText(ind.getTelefono());
        txtDpi.setText(ind.getDPI());
    }

   
    @FXML
    private void nuevo(ActionEvent event) {
        limpiarCampos();
    }

     public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtDpi.setText("");
    }
    
}
