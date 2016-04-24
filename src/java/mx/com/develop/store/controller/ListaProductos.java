package mx.com.develop.store.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mx.com.develop.store.listener.StoreAsyncListener;
import mx.com.develop.store.model.Cliente;
import mx.com.develop.store.model.Producto;

//@ServletSecurity(@HttpConstraint (rolesAllowed = {"Administradores"}))
public class ListaProductos extends HttpServlet { 
    @PersistenceContext
    private EntityManager em;
    @Resource
    private UserTransaction utx;

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
        final AsyncContext contextAsync = request.startAsync();
        contextAsync.setTimeout(22000);
        contextAsync.addListener(new StoreAsyncListener());
        contextAsync.start(new Runnable() {
            @Override
            public void run() {
                try {
                    // simula tarea que demora 10 segundos
                    Thread.sleep(10000);
//                    if(1==1){
//                        throw new RuntimeException("Error en el listener");
//                    }
                    System.out.println("termine tarea compleja");
                    ((HttpServletRequest) contextAsync.getRequest()).getSession()
                       .setAttribute("proceso", "El proceso terminó satisfactoriamente.");
                    contextAsync.complete();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListaProductos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
      
        List <Producto> productos = em.createQuery("SELECT p FROM Producto p ")
                                            .getResultList();
        request.setAttribute("productos", productos );
        System.out.println("productos.size: "+productos.size());
        //enviar la peticion al jsp
        RequestDispatcher rd 
                = request.getRequestDispatcher("lista_productos.jsp");
        rd.forward(request, response);
        response.flushBuffer();
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

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setUtx(UserTransaction utx) {
        this.utx = utx;
    }
    
    

}
