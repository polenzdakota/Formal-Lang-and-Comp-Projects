
/**
 *
 * @author Dakota
 */
public class Trigger {
    private final int currentState;
    private final char currentBit;
    public Trigger(int trigState, char trigBit){
        currentState = trigState;
        currentBit = trigBit;
    }

    /**
     * @return the state
     */
    public int getState() {
        return currentState;
    }

    /**
     * @return the position
     */
    public char getCurrentBit() {
        return currentBit;
    }
}
