
package mx.com.develop.store.listener;

import java.io.IOException;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

/**
 *
 * @author Roberto Olveras
 */
public class StoreAsyncListener implements AsyncListener{

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("onComplete(AsyncEvent event)");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("onTimeout(AsyncEvent event)");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("onError(AsyncEvent event)");
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {
        System.out.println("onStartAsync(AsyncEvent event)");
    }

}
