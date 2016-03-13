/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.tags;

import java.util.List;
import javax.servlet.jsp.JspContext;
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
public class ForEachTag extends SimpleTagSupport {

    private String var;
    private String varStatus;
    private List<Producto> items;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspContext jspContext = getJspContext();
        int i = 1;
        for (Producto p : items) {
            jspContext.setAttribute(var, p, PageContext.PAGE_SCOPE);
            jspContext.setAttribute(varStatus, i++, PageContext.PAGE_SCOPE);
            try {
                JspFragment f = getJspBody();
                if (f != null) {
                    f.invoke(null);
                }
            } catch (java.io.IOException ex) {
                throw new JspException("Error in ForEachTag tag", ex);
            }
        }

    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setVarStatus(String varStatus) {
        this.varStatus = varStatus;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }

}
