
import java.util.ArrayList;


/**
 * This class is a node representing an iteration in a grammar
 * @author Dakota
 */
public class Iteration extends Result {

    public ArrayList<Result> children = new ArrayList<>();
    public void addIteration(Result child) {
        children.add(child);
    }

    @Override
    public String toString() {
        String ret = "[";
        for(Result child: children) {
            ret = ret + " " + child;
        }
        ret = ret + " ]+";
        return ret;
    }
}