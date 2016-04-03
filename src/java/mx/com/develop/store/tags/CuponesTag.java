package mx.com.develop.store.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Roberto Olveras
 */
public class CuponesTag
        extends SimpleTagSupport implements DynamicAttributes {

    Map<String, Object> values = new HashMap<String, Object>();

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        for (Object object : values.values()) {
            out.write(object.toString()+"<br/>");
        }
        JspFragment f = getJspBody();
        if (f != null) {
            f.invoke(out);
        }
    }

    @Override
    public void setDynamicAttribute(String uri,
            String localName, Object value) throws JspException {
        values.put(localName, value);
    }

}
