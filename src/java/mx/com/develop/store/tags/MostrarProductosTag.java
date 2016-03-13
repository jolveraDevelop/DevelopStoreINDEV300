/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.tags;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import mx.com.develop.store.model.Producto;

/**
 *
 * @author jr_ro
 */
public class MostrarProductosTag extends SimpleTagSupport {

    private String columnas;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        List<Producto> productos = (List<Producto>)
                getJspContext().getAttribute("listaProductos",PageContext.APPLICATION_SCOPE);
        int i = 1;
        
        String columNumber[] = this.columnas.split(",");
        for (Producto producto : productos) {
            String line = "<tr>";
            for (String col : columNumber) {
                if(renderedColumn(col)){
                    line += getColumnText(col, producto, i);
                }
            }
            i++;
            line += "</tr>";
            try {
                out.print(line);
            } catch (IOException ex) {
                Logger.getLogger(MostrarProductosTag.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in MostrarProductosTag tag", ex);
        }
    }

    public void setColumnas(String columnas) {
        this.columnas = columnas;
    }
    
    private boolean renderedColumn(String columNumber){
        if(this.columnas != null && 
                this.columnas.equalsIgnoreCase("")) return true;
        String cols[] = this.columnas.split(",");
        if(cols == null) return true;
        for (String column : cols) {
            if(column.equals(columNumber)){
                return true;
            }
        }
        return false;
    }
    
    private String getColumnText(String columNumber,Producto p,int status){
        String result = "<td>";
        int col = Integer.valueOf(columNumber);
            switch (col) {
            case 1:
                result += status;
                break;
            case 2:
                result += p.getDescripcion();
                break;
            case 3:
                result += p.getTipo().getTitulo();
                break;
            case 4:
                result += p.getColor().getTitulo();
                break;
            case 5:
                result += p.getTalla().getTitulo();
                break;   
            case 6:
                result += p.getPrecio();
                break;
            case 7:
                result += p.getDisponibles();
                break;
            case 8:
                result += "<a href=\"./ventas/detalles_producto.view?id="+p.getId()+"\" >\n" +
"                                <img src=\"./imagenes/carrito.png\" width=\"40\" height=\"40\"\n" +
"                                     alt=\"carrito\" />\n" +
"                            </a>";
                break;
            case 9:
                result += "";
                break;
            case 10:
                result += "algo";
                break;
            default:
                throw new AssertionError();
        }
        result += "</td>";
        return result;
    }
        
}
