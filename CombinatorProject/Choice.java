
/**
 * This class is a node representing a choice
 * @author Dakota
 */
public class Choice extends Result {
    private Result choice;
    @Override
    public String toString() {
        String ret;
        ret = "[" + "|" + getChoice() + " ]";
        return ret;
    }

    /**
     * @return the choice
     */
    public Result getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(Result choice) {
        this.choice = choice;
    }
}
