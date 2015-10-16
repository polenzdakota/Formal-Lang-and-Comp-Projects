
/**
 *
 * @author Dakota
 */
public class FSMLabRegEx {

    public static void main(String[] args) {

        //0|[1-9][0-9]*
        FSM m = new FSM();
        m.addTransition('0', 0, 1);
        m.addRangeTransitions('1', '9', 0, 2);
        m.addRangeTransitions('0', '9', 2, 3);
        m.addRangeTransitions('0', '9', 3, 3);
        m.addFinalState(1);
        m.addFinalState(2);
        m.addFinalState(3);
        System.out.println("Tests for expression 0|[1-9][0-9]*\n");
        System.out.println("0: " + m.accept("0") + " :Expected true");
        System.out.println("12: " + m.accept("12") + " :Expected true");
        System.out.println("5020: " + m.accept("5020") + " :Expected true");
        System.out.println("3: " + m.accept("3") + " :Expected true");
        System.out.println("04: " + m.accept("04") + " :Expected false");
        System.out.println("a: " + m.accept("a") + " :Expected false");
        m.reset();
        System.out.println("+++++++++++++++++++++++++++++++");

        //[0-9][0-9]/[0-9][0-9]/[0-9][0-9]
        m.addRangeTransitions('0', '9', 0, 1);
        m.addRangeTransitions('0', '9', 1, 2);
        m.addTransition('/', 2, 3);
        m.addRangeTransitions('0', '9', 3, 4);
        m.addRangeTransitions('0', '9', 4, 5);
        m.addTransition('/', 5, 6);
        m.addRangeTransitions('0', '9', 6, 7);
        m.addRangeTransitions('0', '9', 7, 8);
        m.addFinalState(8);
        System.out.println("Tests for expression [0-9][0-9]/[0-9][0-9]/[0-9][0-9]\n");
        System.out.println("05/12/12: " + m.accept("05/12/12") + " :Expected true");
        System.out.println("05/1212: " + m.accept("05/1212") + " :Expected false");
        System.out.println("May/12/12: " + m.accept("May/12/12") + " :Expected false");
        System.out.println("05/12/: " + m.accept("05/12/") + " :Expected false");
        System.out.println("99/99/99: " + m.accept("05/12/12") + " :Expected true");
        m.reset();
        System.out.println("+++++++++++++++++++++++++++++++");
        
        //[a-c]([a-c]|[0-9])*
        m.addRangeTransitions('a', 'c', 0, 1);
        m.addRangeTransitions('a', 'c', 1, 2);
        m.addRangeTransitions('0', '9', 1, 3);
        m.addRangeTransitions('0', '9', 2, 3);
        m.addRangeTransitions('a', 'c', 3, 2);
        m.addRangeTransitions('0', '9', 3, 3);
        m.addRangeTransitions('a', 'c', 2, 2);
        m.addFinalState(1);
        m.addFinalState(2);
        m.addFinalState(3);
        System.out.println("Tests for expression [a-c]([a-c]|[0-9])*\n");
        System.out.println("a: " + m.accept("a") + " :Expected true");
        System.out.println("c1: " + m.accept("c1") + " :Expected true");
        System.out.println("c2baaa999: " + m.accept("c2baa999") + " :Expected true");
        System.out.println("9abab: " + m.accept("9abab") + " :Expected false");
        m.reset();
    }
}
