/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.store.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 *
 * @author jr_ro
 */
public class CuponesTag extends BodyTagSupport {

    private String items;
    private String delimits;
    private String var;
    private String[] tokens;
    private int count = 0;
    
    public CuponesTag() {
        super();
    }  

    @Override
    public int doAfterBody() throws JspException {
        System.out.println("doAfterBody()");    
        System.out.println("count "+count);
        if(this.count<tokens.length){
            System.out.println("count "+count);
            this.pageContext.setAttribute(this.var,this.tokens[count++]);
            return EVAL_BODY_AGAIN;
        }else{
            return EVAL_PAGE;
        }
    }

    @Override
    public int doEndTag() throws JspException {
        System.out.println("doEndTag()");
        return EVAL_PAGE; //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public int doStartTag() throws JspException {
        this.tokens = this.items.split(this.delimits);
        this.pageContext.setAttribute(this.var,this.tokens[count++]);
        return EVAL_BODY_INCLUDE;
    }
    
    public void setItems(String items) {
        this.items = items;
    }

    public void setDelimits(String delimits) {
        this.delimits = delimits;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setTokens(String[] tokens) {
        this.tokens = tokens;
    }
    
}
