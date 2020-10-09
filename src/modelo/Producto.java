
package modelo;

import otros.Utilerias;


public class Producto {
    
    public static int sigIdProducto = 2000;
    private int id;
    private String nombre;
    private String descripcion;
    private int precio;
    private int cantidad;

    public Producto() {
    this.id=sigIdProducto;
    sigIdProducto ++;
    }

    public Producto(String nombre, String descripcion, int precio, int cantidad) {
        this();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "["+Utilerias.getNombreClase(Producto.class)+"] id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", cantidad=" + cantidad;
    }

    
    
    
    
    
    
    

}
