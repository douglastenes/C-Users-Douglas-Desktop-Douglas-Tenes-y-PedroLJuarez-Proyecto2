
package modelo;

import otros.Utilerias;

public class Cliente {
    public static int sigIdCliente=1;
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String tipoCliente;

    public Cliente() {
        this.id = sigIdCliente;
        sigIdCliente ++;
    }

    public Cliente(String nombre, String direccion, String telefono, String tipoCliente) {
        this();
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
        
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "["+Utilerias.getNombreClase(Cliente.class)+"] id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", tipoCliente=" + tipoCliente;
    }
    
    
    
}
