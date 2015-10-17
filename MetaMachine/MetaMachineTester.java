
/**
 *
 * @author Dakota
 */
public class MetaMachineTester {
    public static void main(String args[]) throws Exception {
        MetaMachine mm = new MetaMachine();
        mm.execute("meta.Greeter", "greetings", "Hello", "Jupiter");
        System.out.print("\n");
        mm.execute("meta.Greeter", "greetings", "This", "Is", "a", "Test!");
        System.out.print("\n");
        mm.execute("meta.RandomTest", "doStuff", "TEST", "TESTER!");
        System.out.print("\n");
        System.out.println("Class does not exist test:");
        mm.execute("meta.DNE", "doStuff", "TEST", "TESTER!");
        System.out.println("Method does not exist test:");
        mm.execute("meta.Greeter", "DNE", "This", "Is", "a", "Test!");
    }
}
