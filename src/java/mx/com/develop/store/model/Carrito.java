/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Humberto
 */
public class Carrito {

    private Map<Producto, Integer> productos;

    public Carrito() {
        productos = new HashMap<>();
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void setProductos(Map<Producto, Integer> productos) {
        this.productos = productos;
    }
}
