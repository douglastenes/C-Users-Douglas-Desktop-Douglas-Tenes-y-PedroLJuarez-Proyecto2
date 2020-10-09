package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Empresa;
import modelo.Individual;
import modelo.Orden;
import otros.Utilerias;


public class GridOrdenController implements Initializable {

    @FXML
    private TextField txtid;
    @FXML
    private GridPane grid;
    @FXML
    private Button btnConsultar;
    private Button txtRegresar;
    @FXML
    private Button btnRegresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void consultarOrden(ActionEvent event) {
        boolean validar = false;
        Orden orden = null;
        for (Orden o : SesionController.ordenes) {
            if (o.getId() == Integer.parseInt(txtid.getText())) {
                validar = true;
                orden = o;
                break;
            }
        }
        if (validar == true) {

            grid.setAlignment(Pos.CENTER);

            Text cliente = new Text("Detalle del cliente: ");
            Text tipoC = new Text("Tipo: ");
            Text txtTipo = new Text(orden.getCliente().getTipoCliente());
            Text id = new Text("ID: ");
            Text txtId = new Text(String.valueOf(orden.getCliente().getId()));
            Text nombreC = new Text("Nombre: ");
            Text txtNombre = new Text(orden.getCliente().getNombre());
            Text direccion = new Text("Direccion: ");
            Text txtDireccion = new Text(orden.getCliente().getDireccion());
            Text telefono = new Text("TEelefono: ");
            Text txtTelefono = new Text(orden.getCliente().getTelefono());
            Text esp0 = new Text("_________________");

            if (orden.getCliente().getTipoCliente().equals("empresa")) {

                Empresa empresa = (Empresa) orden.getCliente();
                Text contacto = new Text("Contacto: ");
                Text txtContacto = new Text(empresa.getContacto());
                Text descuento = new Text("Descuento: ");
                Text txtDescuento = new Text(String.valueOf(empresa.getDescuento()));
                Text valorDescuento = new Text("Descuento");
                Text txtValorDescuento = new Text(Utilerias.formatoMoneda(orden.getDescuento()));

                grid.add(contacto, 0, 7);
                grid.add(txtContacto, 1, 7);
                grid.add(descuento, 0, 8);
                grid.add(txtDescuento, 1, 8);
                grid.add(valorDescuento, 0, 27);
                grid.add(txtValorDescuento, 1, 27);

            } else {
                Individual indi = (Individual) orden.getCliente();
                Text dpi = new Text("DPI: ");
                Text txtDpi = new Text(indi.getDPI());
                Text valorDescuento = new Text("Descuento");
                Text txtValorDescuento = new Text(Utilerias.formatoMoneda(0));

                grid.add(dpi, 0, 7);
                grid.add(txtDpi, 1, 7);
                grid.add(valorDescuento, 0, 27);
                grid.add(txtValorDescuento, 1, 27);
            }

            grid.add(esp0, 0, 0);
            grid.add(cliente, 0, 1);
            grid.add(tipoC, 0, 2);
            grid.add(txtTipo, 1, 2);
            grid.add(id, 0, 3);
            grid.add(txtId, 1, 3);
            grid.add(nombreC, 0, 4);
            grid.add(txtNombre, 1, 4);
            grid.add(direccion, 0, 5);
            grid.add(txtDireccion, 1, 5);
            grid.add(telefono, 0, 6);
            grid.add(txtTelefono, 1, 6);

            Text producto1 = new Text("Producto (1)");
            Text esp1 = new Text("_________________");
            Text idP1 = new Text("ID: ");
            Text txtIdP1 = new Text(String.valueOf(orden.getItem1().getProducto().getId()));
            Text nombreP1 = new Text("Nombre: ");
            Text txtNombreP1 = new Text(orden.getItem1().getProducto().getNombre());
            Text descripcionP1 = new Text("Descripcion: ");
            Text txtDescripcionP1 = new Text(orden.getItem1().getProducto().getDescripcion());
            Text precioP1 = new Text("Precio Unidad");
            Text txtPrecioP1 = new Text(Utilerias.formatoMoneda(orden.getItem1().getProducto().getPrecio()));
            Text cantidadP1 = new Text("Cantidad");
            Text txtCantidadP1 = new Text(String.valueOf(orden.getItem1().getCantidad()));

            grid.add(esp1, 0, 9);
            grid.add(producto1, 0, 10);
            grid.add(idP1, 0, 11);
            grid.add(txtIdP1, 1, 11);
            grid.add(nombreP1, 0, 12);
            grid.add(txtNombreP1, 1, 12);
            grid.add(descripcionP1, 0, 13);
            grid.add(txtDescripcionP1, 1, 13);
            grid.add(precioP1, 0, 14);
            grid.add(txtPrecioP1, 1, 14);
            grid.add(cantidadP1, 0, 15);
            grid.add(txtCantidadP1, 1, 15);

            Text se = new Text("________________");
            Text producto2 = new Text("Producto (2)");
            Text idP2 = new Text("ID: ");
            Text txtIdP2 = new Text(String.valueOf(orden.getItem2().getProducto().getId()));
            Text nombreP2 = new Text("Nombre: ");
            Text txtNombreP2 = new Text(orden.getItem2().getProducto().getNombre());
            Text descripcionP2 = new Text("Descripcion: ");
            Text txtDescripcionP2 = new Text(orden.getItem2().getProducto().getDescripcion());
            Text precioP2 = new Text("Precio Unidad");
            Text txtPrecioP2 = new Text(Utilerias.formatoMoneda(orden.getItem2().getProducto().getPrecio()));
            Text cantidadP2 = new Text("Cantidad");
            Text txtCantidadP2 = new Text(String.valueOf(orden.getItem2().getCantidad()));

            grid.add(se, 0, 16);
            grid.add(producto2, 0, 17);
            grid.add(idP2, 0, 18);
            grid.add(txtIdP2, 1, 18);
            grid.add(nombreP2, 0, 19);
            grid.add(txtNombreP2, 1, 19);
            grid.add(descripcionP2, 0, 20);
            grid.add(txtDescripcionP2, 1, 20);
            grid.add(precioP2, 0, 21);
            grid.add(txtPrecioP2, 1, 21);
            grid.add(cantidadP2, 0, 22);
            grid.add(txtCantidadP2, 1, 22);

            Text espS = new Text("________________");
            Text subTotales = new Text("Subtotal: ");
            Text valorProducto1 = new Text("Producto (1): ");
            Text txtValorProducto1 = new Text(Utilerias.formatoMoneda(orden.getItem1().getTotalItem()));
            Text valorProducto2 = new Text("Producto (2): ");
            Text txtValorProducto2 = new Text(Utilerias.formatoMoneda(orden.getItem2().getTotalItem()));
            Text valorEnvio = new Text("Envio:");
            Text txtValorEnvio = new Text(Utilerias.formatoMoneda(orden.getPrecioEnvio()));
            Text esTotal = new Text("________________");
            Text total = new Text("Total");
            Text txtTotal = new Text(Utilerias.formatoMoneda(orden.getTotalOrden()));
            Text esFin = new Text("________________");

            grid.add(espS, 0, 23);
            grid.add(subTotales, 0, 24);
            grid.add(valorProducto1, 0, 25);
            grid.add(txtValorProducto1, 1, 25);
            grid.add(valorProducto2, 0, 26);
            grid.add(txtValorProducto2, 1, 26);
            grid.add(valorEnvio, 0, 28);
            grid.add(txtValorEnvio, 1, 28);
            grid.add(esTotal, 0, 29);
            grid.add(total, 0, 30);
            grid.add(txtTotal, 1, 30);
            grid.add(esFin, 0, 31);
            btnConsultar.setDisable(true);
        } else {
            JOptionPane.showMessageDialog(null, "No Existe numero de Orden!", "Buscar Orden", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void closeWindows() {
    }


    }

