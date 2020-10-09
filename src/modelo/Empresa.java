
package modelo;


public class Empresa extends Cliente{
    private String contacto;
    private int descuento;

    public Empresa(String contacto, int descuento, String nombre, String direccion, String telefono, String tipoCliente) {
        super(nombre, direccion, telefono, tipoCliente);
        this.contacto = contacto;
        this.descuento = descuento;
    }

    public String getContacto() {
        return contacto;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return  super.toString() +", contacto=" + contacto + ", descuento=" + descuento;
    }
    
    
    
}
