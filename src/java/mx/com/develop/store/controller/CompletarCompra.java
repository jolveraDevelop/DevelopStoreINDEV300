/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Carrito;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Factura;

/**
 *
 * @author Humberto
 */
@WebServlet(name = "CompletarCompra", urlPatterns = {"/ventas/completar_compra.do"})
public class CompletarCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        ServletContext context = getServletContext();

        if (session != null) {
            Carrito venta = (Carrito) session.getAttribute("carrito");
            if (venta != null) {
                Map<Producto, Integer> productos = venta.getProductos();
                double total = 0.0;
                Set<Producto> set = productos.keySet();
                for (Producto producto : set) {
                    total += producto.getPrecio() * productos.get(producto);
                }
                //Cupones de descuento.
                //String cupones[] = {"sdfgtr","yudfsa","wetjgh"};
                String cupones ="sdfgtr,yudfsa,wetjgh";
                request.setAttribute("cupones",cupones);
                //Vaciar el crrito de compras.                
                session.removeAttribute("carrito");
                //Compartir los productos del carrito, los cupones y el total de la compra.
                request.setAttribute("venta", venta);
                request.setAttribute("factura", new Factura(1,(Cliente)session.getAttribute("cliente"),
                                                                                        null,0.0,0.0,total));
                
                request.getRequestDispatcher("completar_compra.jsp").forward(request, response);
            } else {
                venta = new Carrito();
                response.sendRedirect("lista_carrito_error.jsp");
            }
        } else {
            response.sendRedirect("lista_carrito_error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
