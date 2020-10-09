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
import modelo.Empresa;

public class EmpController implements Initializable {

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
    private TextField txtContacto;
    @FXML
    private TextField txtDescuento;
    @FXML
    private TableView<Empresa> tabla;
    @FXML
    private TableColumn<Empresa, Integer> colId;
    @FXML
    private TableColumn<Empresa, String> colNombre;
    @FXML
    private TableColumn<Empresa, String> colTelefono;
    @FXML
    private TableColumn<Empresa, String> colContacto;
    @FXML
    private TableColumn<Empresa, Integer> colDescuento;
    @FXML
    private Button btnActualizar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtId;
    @FXML
    private Button btnNuevo;
    @FXML
    private TableColumn<Empresa, String> colDireccion;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarEmpresas();
    }

   
 //modificar datos de empresas
    @FXML
    private void actualizar(ActionEvent event) {
        int posicion = 0;
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            for (Cliente cliente : SesionController.clientes) {
                if (Integer.parseInt(txtId.getText()) == cliente.getId()) {
                    posicion = SesionController.clientes.indexOf(cliente);
                    break;
                }
            }
            empresa.setId(Integer.parseInt(txtId.getText()));
            SesionController.clientes.set(posicion, empresa);
            Cliente.sigIdCliente--;
            JOptionPane.showMessageDialog(null, "Modificar Dato", "Modificado", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            limpiarCampos();
        } catch (Exception e) {
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
            mostrarEmpresas();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }

    public ObservableList<Empresa> getEmpresas() {
        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList();

        for (Cliente c : SesionController.clientes) {
            if (c.getTipoCliente().equals("empresa")) {
                Empresa e = (Empresa) c;
                listaEmpresas.add(e);
            }
        }
        return listaEmpresas;
    }

    public void mostrarEmpresas() {
        ObservableList<Empresa> list = getEmpresas();
        colId.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("Contacto"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("Descuento"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
        tabla.setItems(list);
    }

    public void closeWindows() {
    }


    @FXML
    private void click(MouseEvent event) {
        Empresa empresa = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(empresa.getId()));
        txtNombre.setText(empresa.getNombre());
        txtContacto.setText(empresa.getContacto());
        txtDescuento.setText(String.valueOf(empresa.getDescuento()));
        txtDireccion.setText(empresa.getDireccion());
        txtTelefono.setText(empresa.getTelefono());
    }

    public void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtContacto.setText("");
        txtDescuento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    @FXML
    private void nuevo(ActionEvent event) {
        limpiarCampos();
    }

    @FXML
    private void registrarEmpresa(ActionEvent event) {
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            SesionController.clientes.add(empresa);
            JOptionPane.showMessageDialog(null, "Datos Agregados!", "Agregado", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            limpiarCampos();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, dato no valido", "ERROR", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
        }
    }
}
