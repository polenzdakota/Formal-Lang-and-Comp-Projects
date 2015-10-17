
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dakota
 */
public class TuringMachine {

    private Tape tape;
    private Map<Trigger, Action> program;
    private Set<Integer> finalStates;
    private int state;

    public TuringMachine(Tape input) {
        tape = input;
        program = new HashMap<>();
        finalStates = new HashSet<>();
    }

    public void addStep(Trigger current, Action next) {
        program.put(current, next);
    }

    void addFinalState(Integer state) {
        finalStates.add(state);
    }

    public void run() {
        boolean notReachedFinal = true;
        while (notReachedFinal) {
            notReachedFinal = checkTriggers();
        }
    }

    public boolean checkTriggers() {
        for (Trigger trig : program.keySet()) {
            if (tape.read() == trig.getCurrentBit() && trig.getState() == state) {
                int nextState = envokeAction((Action) program.get(trig));
                state = nextState;
                return !finalStates.contains(state);
            }
        }
        return true;
    }

    public int envokeAction(Action action) {
        int nextState = action.getNewState();
        char writeBit = action.getNewBit();
        int direction = action.getDirection();

        tape.write(writeBit);
        tape.moveHead(direction);

        return nextState;
    }

    public String toString() {
        return tape.toString();
    }
}
