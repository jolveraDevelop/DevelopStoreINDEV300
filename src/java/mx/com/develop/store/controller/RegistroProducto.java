/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Color;
import mx.com.develop.store.model.Producto;
import mx.com.develop.store.model.Talla;
import mx.com.develop.store.model.TipoProducto;
import javax.servlet.RequestDispatcher;


/**
 * 
 * @author Humberto BanueloS
 */
public class RegistroProducto extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 * 
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List <String> listaErrores = new ArrayList <String>();
		Color color = null;
		double precio = 0.0;
		Talla talla = null;
		String descripcion = null;
		TipoProducto tipo = null;
		try
		{
			color = Color.valueOf(request.getParameter("color"));
		} catch (IllegalArgumentException e)
		{
			listaErrores.add("Debes seleccionar el 'Color' del producto, es un campo obligatorio.");
		}

		try
		{
			precio = new Double(request.getParameter("precio"));
		} catch (NumberFormatException e)
		{
			listaErrores.add("El precio debe ser un numero decimal.");
		}
		try
		{
			talla = Talla.valueOf(request.getParameter("talla"));
		} catch (IllegalArgumentException e)
		{
			listaErrores.add("Debes seleccionar la 'Talla' del producto, es un campo obligatorio.");
		}
		descripcion = request.getParameter("descripcion");
		try
		{
			tipo = TipoProducto.valueOf(request.getParameter("tipo"));
		} catch (IllegalArgumentException e)
		{
			listaErrores.add("Debes seleccionar el 'Tipo' del producto, es un campo obligatorio.");
		}

                
		if (listaErrores.isEmpty())
		{
			Producto producto = new Producto(color, precio, talla, descripcion, tipo);
			request.setAttribute("producto", producto);
                        
                        List<Producto> listaProductos = 
                                            (List<Producto>)
                                                this.getServletContext()
                                                 .getAttribute("listaProductos");
                        
//                        if(listaProductos == null){
//                            this.getServletContext()
//                                    .setAttribute("listaProductos", 
//                                            new ArrayList<Producto>());
//                            listaProductos = (List<Producto>)
//                                                this.getServletContext()
//                                                 .getAttribute("listaProductos");
//                        }
                        
                        listaProductos.add(producto);

                        //colocar el producto en aplication o servletcontext 
                        // validar si existe una lista de productos en servletcontext
                        // add producto
                        // new listaProcutos y add prodcuto
			RequestDispatcher rd = request.getRequestDispatcher("registro_producto_success.jsp");
			rd.forward(request, response);
		} else
		{
			request.setAttribute("listaErrores", listaErrores);
			RequestDispatcher rd = request.getRequestDispatcher("registro_producto_error.jsp");
			rd.forward(request, response);
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
