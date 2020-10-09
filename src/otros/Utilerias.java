
package otros;

import java.text.DecimalFormat;
import java.util.Locale;


public class Utilerias {
    
    
    public  static String getNombreClase(Class clase) {
        return clase.getSimpleName();
    }
    
    public static String formatoMoneda(double num){
       return (DecimalFormat.getCurrencyInstance(Locale.US).format(num)) ;
    }
    public static String formatoMoneda(int num){
       return (DecimalFormat.getCurrencyInstance(Locale.US).format(num)) ;
    }
    
    
}
