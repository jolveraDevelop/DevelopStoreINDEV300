package mx.com.develop.store.tags;

import java.text.NumberFormat;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author jr_ro
 */
public class FormatearMonedaTag extends SimpleTagSupport {

    private Double valor;

    @Override
    public void doTag() throws JspException {
        System.out.println("doTag() de formatearMoneda");
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(3);
        String valorFormateado = nf.format(valor);
        try {
            out.print(valorFormateado);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in FormatearMonedaTag tag", ex);
        }
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
}
