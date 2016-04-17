
package mx.com.develop.store.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Roberto Olveras
 */
@WebListener
public class ListenerAppDevelopStore 
        implements HttpSessionListener, HttpSessionAttributeListener{

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("sessionCreated(HttpSessionEvent se)");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("sessionDestroyed(HttpSessionEvent se)");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("attributeAdded(HttpSessionBindingEvent event)");
        System.out.println("event.getName(): "+event.getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("attributeRemoved(HttpSessionBindingEvent event)");
        System.out.println("event.getName(): "+event.getName());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("attributeReplaced(HttpSessionBindingEvent event)");
        System.out.println("event.getName(): "+event.getName());
    }
    
    

}
