
package mx.com.develop.store.funciones;

/**
 *
 * @author Roberto Olveras
 */
public class CalcularFactura {
    
    public static double subTotal(double total){
        System.out.println("subTotal(double total)");
        return total - iva(total);
    }
    
    public static double iva(double total){
        System.out.println("iva(double total)");
        return total/1.16;
    }
}
