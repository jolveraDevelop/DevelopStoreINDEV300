package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.develop.store.model.Cliente;
public class ListaProductos extends HttpServlet {  

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init(config); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("init(ServletConfig config) ");
//    }
//
//    @Override
//    public void init() throws ServletException {
//        //este es el punto de inicio de tu servlet
//        System.out.println("init() ");
//        
//    }
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        super.service(req, res); //To change body of generated methods, choose Tools | Templates.
//        System.out.println("service(ServletRequest req, ServletResponse res) ");
//       
//    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp); //To change body of generated methods, choose Tools | Templates.
        System.out.println("service(HttpServletRequest req, HttpServletResponse res) ");
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("Lista de nombres de parametros:");
        
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            System.out.println("nextElement: "+nextElement);
        }
        System.out.println("req.getContentLength(): "+req.getContentLength());
        System.out.println("req.getProtocol(): "+req.getProtocol());
        System.out.println("req.getContextPath(): "+req.getContextPath());
        System.out.println("req.getRequestURI(): "+req.getRequestURI());
        System.out.println("req.getRequestURL(): "+req.getRequestURL());
        System.out.println("req.getServletPath(): "+req.getServletPath());
        System.out.println("req.getRealPath(): "+req.getRealPath("/imagenes/1.png"));
        
        System.out.println("req.getHeader(\"User-Agent\"): "+req.getHeader("User-Agent"));
        System.out.println("req.getHeader(\"Accept-Language\")"+req.getHeader("Accept-Language"));
        if(req.getMethod().equalsIgnoreCase("GET")){
            processRequest(req,resp);
        }
        ServletContext sc = this.getServletContext();
        //informacion del servlet context 
        System.out.println("serverInfo: "+sc.getServerInfo());
        System.out.println("getContextPath: "+sc.getContextPath());
        System.out.println("getServletContextName: "
                                    +sc.getServletContextName());
        
        
    }

//    @Override
//    public void destroy() {
//        System.out.println("destroy()");
//    }
//    
//    @PostConstruct
//    public void despuesInit(){
//        System.out.println("despuesInit()");    
//    }
//
//    @PreDestroy
//    public void antesDestroy(){
//        System.out.println("antesDestroy()");
//    }
//    
    
    
    
    

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // logica de negocio
        request.setAttribute("user", new Cliente("Roberto Olvera", 24, "llll", "5555", "rolvera", "rolvera"));
        
        // recuperar lista de productos del contexto
        // agregarla al request 
        
        // colocar como atributo la lista para que la vista la renderise
        request.setAttribute("productos", 
                this.getServletContext().getAttribute("listaProductos"));
        //enviar la peticion al jsp
        RequestDispatcher rd 
                = request.getRequestDispatcher("lista_productos.jsp");
        rd.forward(request, response);
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
