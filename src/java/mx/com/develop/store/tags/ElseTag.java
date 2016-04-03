/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.tags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author jr_ro
 */
public class ElseTag extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        IfTag parent = (IfTag)findAncestorWithClass(this,IfTag.class);
        if (!parent.isTest()) {
            try {
                getJspBody().invoke(null);
            } catch (java.io.IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
