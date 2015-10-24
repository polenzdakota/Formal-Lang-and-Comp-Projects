
import java.util.regex.*;

/**
 * This class represents a literal in a grammar
 * @author Dakota
 */
public class Literal extends Result {

    private String token;

    @Override
    public String toString() {
        if (getToken() != null) {
            String ret;
            ret = getToken();
            return "<" + ret + ">";
        } else {
            return super.toString();
        }
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
}
