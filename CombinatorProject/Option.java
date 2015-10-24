

/**
 * This class is a node representing an option in a grammar
 * @author Dakota
 */
public class Option extends Result {
    private Result child;
    @Override
    public String toString() {
        String ret;
        ret = "[ " + getChild() + " ]?";
        return ret;
    }

    /**
     * @return the child
     */
    public Result getChild() {
        return child;
    }

    /**
     * @param child the child to set
     */
    public void setChild(Result child) {
        this.child = child;
    }
}
