import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * @author wangjinyang@g7.com.cn
 */
public class MyClient {
    public static void main(String[] args) {
        LoginContext loginContext = null;

        try {
            loginContext = new LoginContext("WeatherLogin", new MyCallbackHandler());
        } catch (LoginException e) {
            System.err.println("LoginContext cannot be created. " + e.getMessage());
            System.exit(-1);
        } catch (SecurityException se) {
            System.err.println("LoginContext cannot be created. " + se.getMessage());
        }
        try {
            loginContext.login();
        } catch (LoginException e) {
            System.out.println("Authentication failed. " + e.getMessage());
            System.exit(-1);
        }
        System.out.println("Authentication succeeded.");
        System.exit(-1);
    }
}
