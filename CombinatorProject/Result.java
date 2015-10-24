
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Dakota
 */
public class Result {

    protected List<String> unseen; // unprocessed tokens
    private boolean fail; // parser error

    //# unseen tokens
    public int pending() {
        return unseen.size();
    }

    public Result(String s, String regEx) {
        fail = false;
        String[] a = s.split(regEx);
        unseen = new ArrayList<String>();
        for (int i = 0; i < a.length; i++) {
            unseen.add(a[i]);
        }
    }

    public Result(String s) {
        this(s, "\\s+");
    }

    public Result() {
        unseen = new ArrayList<String>();
        fail = false;
    }

    public String toString() {
        return "[fail = " + isFail() + "; unseen = " + unseen + "]";
    }

    /**
     * @return the fail
     */
    public boolean isFail() {
        return fail;
    }

    /**
     * @param fail the fail to set
     */
    public void setFail(boolean fail) {
        this.fail = fail;
    }
}
