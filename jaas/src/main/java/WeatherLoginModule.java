import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;
import java.util.Set;

/**
 * @author wangjinyang@g7.com.cn
 */
public class WeatherLoginModule implements LoginModule {
    private Subject subject;
    private CallbackHandler callbackHandler;
    private ExamplePrincipal entity;
    private static final int NOT = 0;
    private static final int OK = 1;
    private static final int COMMIT = 2;

    private int status;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        status = NOT;
        entity = null;
        this.subject = subject;
        this.callbackHandler = callbackHandler;
    }

    @Override
    public boolean login() throws LoginException {
        if (callbackHandler == null) {
            throw new LoginException("No callback handler is available");
        }
        Callback[] callbacks = new Callback[1];
        callbacks[0] = new NameCallback("What is the weather like today?");
        String name = null;
        try {
            callbackHandler.handle(callbacks);
            name = ((NameCallback) callbacks[0]).getName();
        } catch (IOException e) {
            throw new LoginException(e.toString());
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Error: " + e.getCallback().toString());
        }
        if (name.equals("Sunny")) {
            entity = new ExamplePrincipal("SunnyDay");
            status = OK;
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean commit() throws LoginException {
        if (status == NOT) {
            return false;
        }
        if (subject == null) {
            return false;
        }
        Set entities = subject.getPrincipals();
        //若不包含这个实体
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
        status = COMMIT;
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        if (subject != null && entity != null) {
            Set<Principal> principals = subject.getPrincipals();
            if (principals.contains(entity)) {
                principals.remove(entity);
            }
        }
        subject = null;
        entity = null;
        status = NOT;
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(entity);
        status = NOT;
        subject = null;
        return true;
    }
}
