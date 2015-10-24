
/**
 *
 * @author Dakota
 */
public class Concatenation extends Result {
    private Result child1;
    private Result child2;
    
    @Override
    public String toString() {
        String ret;
        ret = "[ " + getChild1() + " ~ " + getChild2() + " ]";
        return ret;
    }

    /**
     * @return the child1
     */
    public Result getChild1() {
        return child1;
    }

    /**
     * @param child1 the child1 to set
     */
    public void setChild1(Result child1) {
        this.child1 = child1;
    }

    /**
     * @return the child2
     */
    public Result getChild2() {
        return child2;
    }

    /**
     * @param child2 the child2 to set
     */
    public void setChild2(Result child2) {
        this.child2 = child2;
    }
}
