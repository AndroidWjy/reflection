import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author wangjinyang@g7.com.cn
 */
public class MyCallbackHandler implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                NameCallback nc = (NameCallback) callbacks[0];
                System.err.println(nc.getPrompt());
                System.err.flush();
                String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
                nc.setName(name);
            }
        }
    }
}
