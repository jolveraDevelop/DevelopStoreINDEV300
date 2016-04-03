/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.tags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author jr_ro
 */
public class IfTag extends SimpleTagSupport {

    private boolean test;
    @Override
    public void doTag() throws JspException {
        try {
            getJspBody().invoke(null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public boolean isTest() {
        return test;
    }
    
    
    
}
