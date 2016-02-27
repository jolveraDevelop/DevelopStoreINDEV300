/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.develop.store.model.Producto;

/**
 *
 * @author Humberto
 */
@WebServlet(name = "ProductoDetalles", urlPatterns = {"/ventas/detalles_producto.view"})
public class DetallesProducto extends HttpServlet {

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
        HttpSession session = request.getSession(true);
        if (session != null) {
            if (true) {
                ServletContext context = getServletContext();
                List<Producto> productos = (List<Producto>) context.getAttribute("listaProductos");
                Integer idProducto = Integer.parseInt(request.getParameter("id"));
                boolean encontrado = false;

                if (productos != null) {
                    for (Producto producto : productos) {
                        if (idProducto.equals(producto.getId())) {
                            request.setAttribute("producto", producto);
                            encontrado = true;
                        }
                    }
                    if (encontrado) {
                        request.getRequestDispatcher("detalles_producto.jsp").forward(request, response);
                    } else {
                        response.sendRedirect("detalles_producto_error.jsp");
                    }
                } else {
                    response.sendRedirect("lista_productos_error.jsp");
                }
            } else {
                response.sendRedirect("detalles_producto_error.jsp");
            }
        } else {
            response.sendRedirect("detalles_producto_error.jsp");
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
