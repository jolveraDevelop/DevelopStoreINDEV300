/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Carrito;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Producto;

/**
 *
 * @author jr_ro
 */
public class AgregarCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Cliente client = (Cliente) session.getAttribute("cliente");
            if (client != null) {
                Carrito carrito = session.getAttribute("carrito") != null
                        ? (Carrito) session.getAttribute("carrito")
                        : new Carrito();
                Integer idProdSolicitado
                        = Integer.valueOf(request.getParameter("id"));
                Integer cantidadSolicitada
                        = Integer.valueOf(request.getParameter("cantidad"));
                List<Producto> productos
                        = (List<Producto>) this.getServletContext()
                        .getAttribute("listaProductos");
                for (Producto producto : productos) {
                    if (producto.getId().equals(idProdSolicitado)) {
                        carrito.addProducto(producto, cantidadSolicitada);
                        // descontar de disponibles la cantidad solicitada del producto 
                        // que esta en la lista de servlet context
                    }
                }
                session.setAttribute("carrito", carrito);
                request.getRequestDispatcher("lista_carrito.jsp")
                        .forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
