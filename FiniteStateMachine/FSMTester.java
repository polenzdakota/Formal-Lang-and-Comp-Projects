
/**
 *
 * @author Dakota
 */
public class FSMTester {

    public static void main(String[] args) {
        FSM m = new FSM();
        System.out.println("Provided test cases");
        m.addTransition('0', 0, 1);
        m.addTransition('0', 1, 1);
        m.addTransition('1', 1, 2);
        m.addTransition('0', 2, 3);
        m.addTransition('1', 2, 2);
        m.addTransition('0', 3, 3);
        m.addFinalState(3);

        System.out.println("0011100: " + m.accept("0011100"));
        System.out.println("01100: " + m.accept("01100"));
        System.out.println("11100: " + m.accept("11100"));
        System.out.println("001110011: " + m.accept("001110011"));

        m.reset(); // clear all transitions and final states
        System.out.println("++++++++++++++++++++++\n");
        System.out.println("Testing reset");
        System.out.println("000: " + m.accept("00") + " :Expected False");
        System.out.println("001: " + m.accept("001") + " :Expected False");
        System.out.println("++++++++++++++++++++++\n");

        System.out.println("Char tests\nExpression: abc");
        m.addTransition('a', 0, 1);
        m.addTransition('b', 1, 2);
        m.addTransition('c', 2, 3);
        m.addFinalState(3);

        System.out.println("123: " + m.accept("123") + " :Expected False");
        System.out.println("aabc: " + m.accept("aabc") + " :Expected False");
        System.out.println("abc: " + m.accept("abc") + " :Expected True");
        m.reset();

        System.out.println("++++++++++++++++++++++\n");
        System.out.println("Testing option\nExpression: a(b|c)");
        m.addTransition('a', 0, 1);
        m.addTransition('b', 1, 2);
        m.addTransition('c', 1, 3);
        m.addFinalState(2);
        m.addFinalState(3);

        System.out.println("ac: " + m.accept("ac") + " :Expected True");
        System.out.println("ab: " + m.accept("ab") + " :Expected True");
        System.out.println("abc: " + m.accept("abc") + " :Expected False");
        m.reset();

        System.out.println("++++++++++++++++++++++\n");
        System.out.println("Testing loops\nExpression: (ab)*");
        m.addTransition('a', 0, 1);
        m.addTransition('b', 1, 2);
        m.addTransition('a', 2, 1);
        m.addFinalState(2);

        System.out.println("abababab: " + m.accept("abababab") + " :Expected True");
        System.out.println("ab: " + m.accept("ab") + " :Expected True");
        System.out.println("ababa: " + m.accept("ababa") + " :Expected False");

    }
}
