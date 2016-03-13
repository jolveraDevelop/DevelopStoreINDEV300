/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.listener;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import mx.com.develop.store.controller.ListaProductos;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;

/**
 * Web application lifecycle listener.
 *
 * @author jr_ro
 */
@WebListener()
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        ServletRegistration.Dynamic listaProductos = 
                sc.addServlet("ListaProductos", ListaProductos.class);
        listaProductos.addMapping("/lista_productos.view");
        
        List<Producto> productos = new ArrayList<Producto>();
        productos.add(new Producto(1, Color.ROJO, 199.0, Talla.CHICA,
                "Playera para niño de x", TipoProducto.PLAYERA));
        productos.add(new Producto(2, Color.AZUL, 299.0, Talla.MEDIANA,
                "Blusa para dama marca x", TipoProducto.BLUSA));
        productos.add(new Producto(3, Color.CAFE, 149.0, Talla.GRANDE,
                "Camisa manga larga", TipoProducto.CAMISA));
        productos.add(new Producto(4, Color.VERDE, 499.0, Talla.EXTRA_GRANDE,
                "Pantalon de mezclilla marca f", TipoProducto.PANTALON));
        
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Roberto Olvera", 25, 
                                "calle 1","7797890" , 
                                            "rolvera", "rolvera"));
        clientes.add(new Cliente("Raul Villasana", 28, 
                                "calle 4","7867232" , 
                                            "rvilla", "rvilla"));
        
        sc.setAttribute("clientes", clientes);
        sc.setAttribute("listaProductos",  productos);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
