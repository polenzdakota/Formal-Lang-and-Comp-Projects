
import java.util.Map;
import java.util.HashMap;

/**
 * This class creates a finite state machine that checks provided strings and
 * determines if those strings lead to a final state.
 *
 * @author Dakota
 */
public class FSM {

    private Map<Integer, State> states = new HashMap<>();

    public FSM() {
        State iniState = new State(0);
        State deadState = new State(-1);
        states.put(0, iniState);
        states.put(-1, deadState);
    }

    /**
     * Adds a transition to a given state
     *
     * @param ch The transitive identity
     * @param from The state to add the transition to
     * @param to The state the transition is to
     */
    public void addTransition(char ch, int from, int to) {
        if (!states.containsKey(to)) {
            State toState = new State(to);
            states.put(to, toState);
        }
        states.get(from).addTransition(to, ch);
    }

    public void addRangeTransitions(Character startChar, Character endChar, int from, int to) {
        Character currentChar = startChar;
        for (int i = startChar; i <= endChar; i++) {
            addTransition(currentChar, from, to);
            currentChar++;
        }
    }

    /**
     * Makes the given state a final state
     *
     * @param finish the given state identifier
     */
    public void addFinalState(int finish) {
        states.get(finish).makeFinal();
    }

    /**
     * Reads a string and determines if the FSM is valid for that string
     *
     * @param input The given string
     * @return true if the string is valid
     */
    public boolean accept(String input) {
        int currentState = 0;
        char currentIdentifier;
        for (int i = 0; i < input.length(); i++) {
            currentIdentifier = input.charAt(i);
            int nextState = states.get(currentState).nextState(currentIdentifier);
            currentState = nextState;
        }
        return states.get(currentState).returnFinal();
    }

    /**
     * Clears all states current within the state map
     */
    public void reset() {
        states.clear();
        State iniState = new State(0);
        State deadState = new State(-1);
        states.put(0, iniState);
        states.put(-1, deadState);

    }

    /**
     * Class that holds all data for a state
     */
    private class State {

        private Map<Character, Integer> transitions = new HashMap<>();
        boolean finalState = false;
        int stateNum;

        /**
         * Initializes a state
         *
         * @param iniIdent the states numeric identifier
         */
        public State(int iniIdent) {
            stateNum = iniIdent;
        }

        /**
         * Makes the state a final state
         */
        public void makeFinal() {
            finalState = true;
        }

        /**
         * Adds a transition to this state
         *
         * @param toState The state that it will go to
         * @param identifier The identifier that determines if if will
         * transition to the toState
         */
        public void addTransition(int toState, Character identifier) {
            transitions.put(identifier, toState);
        }

        /**
         * Returns if this state is a final state
         *
         * @return true if this state is a final state
         */
        public boolean returnFinal() {
            return finalState;
        }

        /**
         * Returns the transitions for this state
         *
         * @return The transitions for this state as a map
         */
        public Map<Character, Integer> returnTransitions() {
            return transitions;
        }

        /**
         * returns the state identifier for the next character given
         *
         * @param nextIdentifier the character given
         * @return The next state or -1 if no states matches the transitions
         */
        public Integer nextState(char nextIdentifier) {
            if (!transitions.containsKey(nextIdentifier)) {
                return -1;
            } else {
                return transitions.get(nextIdentifier);
            }
        }
    }
}
