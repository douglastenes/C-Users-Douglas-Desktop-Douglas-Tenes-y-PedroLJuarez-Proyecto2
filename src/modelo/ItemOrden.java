package modelo;

public class ItemOrden {
    
    private int noLinea;
    private int cantidad;
    private Producto producto;

    public ItemOrden(int noLinea, int cantidad, Producto producto) {
        this.noLinea = noLinea;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getNoLinea() {
        return noLinea;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setNoLinea(int noLinea) {
        this.noLinea = noLinea;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getTotalItem(){
        return cantidad * producto.getPrecio();
    }

    @Override
    public String toString() {
        return  "ItemOrden{" + "noLinea=" + noLinea + ", cantidad=" + cantidad + ", producto=" + producto + '}';
    }
 
    
    
}
