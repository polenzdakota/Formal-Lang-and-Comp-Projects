
/**
 *
 * @author Dakota
 */
public class Action {
    private final int newState;
    private final char newBit;
    private final int direction;
    
    public Action(int nextState, char nextBit, int nextDirection) {
        newState = nextState;
        newBit = nextBit;
        direction = nextDirection;
    }

    /**
     * @return the toState
     */
    public int getNewState() {
        return newState;
    }

    /**
     * @return the toPosition
     */
    public char getNewBit() {
        return newBit;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }
}
