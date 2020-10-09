package modelo;

public class Individual extends Cliente{
    private String DPI;

    public Individual(String DPI, String nombre, String direccion, String telefono, String tipoCliente) {
        super(nombre, direccion, telefono, tipoCliente);
        this.DPI = DPI;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    @Override
    public String toString() {
        return super.toString() + ", DPI=" + DPI;
    }
    
    
}
