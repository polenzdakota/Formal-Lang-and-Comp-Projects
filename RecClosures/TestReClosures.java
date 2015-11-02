
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Dakota
 */
public class TestReClosures {

    private static Function<Integer, Integer> multThree = x -> x * 3;
    private static Function<Integer, Integer> multTwo = x -> x * 2;

    public static boolean multOfTwo(Integer x) {
        return x % 2 == 0;
    }

    public static boolean multOfThree(Integer x) {
        return x % 3 == 0;
    }

    public static boolean lessThan10(Integer x) {
        return x < 10;
    }

    public static boolean greaterThan10(Integer x) {
        return x > 10;
    }

    public static void testUnion() {
        Predicate<Integer> memA = TestReClosures::multOfTwo;
        Predicate<Integer> memB = TestReClosures::multOfThree;
        Predicate<Integer> result = RecClosures.union(memA, memB);
        Predicate<Integer> memC = TestReClosures::lessThan10;
        Predicate<Integer> memD = TestReClosures::greaterThan10;
        Predicate<Integer> resultA = RecClosures.union(memC, memD);

        System.out.println("testing x % 2 == 0 and x % 3 == 0");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + result.test(i));
        }

        System.out.println("Testing x < 10 and x > 10");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + resultA.test(i));
        }
    }

    public static void testIntersection() {
        Predicate<Integer> memA = TestReClosures::multOfTwo;
        Predicate<Integer> memB = TestReClosures::multOfThree;
        Predicate<Integer> result = RecClosures.intersection(memA, memB);
        Predicate<Integer> memC = TestReClosures::lessThan10;
        Predicate<Integer> memD = TestReClosures::greaterThan10;
        Predicate<Integer> resultA = RecClosures.intersection(memC, memD);

        System.out.println("testing x % 2 == 0 and x % 3 == 0");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + result.test(i));
        }

        System.out.println("Testing x < 10 and x > 10");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + resultA.test(i));
        }
    }

    public static void testDifferance() {
        Predicate<Integer> memA = TestReClosures::multOfTwo;
        Predicate<Integer> memB = TestReClosures::multOfThree;
        Predicate<Integer> result = RecClosures.differance(memA, memB);
        Predicate<Integer> memC = TestReClosures::lessThan10;
        Predicate<Integer> memD = TestReClosures::greaterThan10;
        Predicate<Integer> resultA = RecClosures.differance(memC, memD);

        System.out.println("testing x % 2 == 0 and x % 3 == 0");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + result.test(i));
        }

        System.out.println("Testing x < 10 and x > 10");
        for (int i = 1; i <= 20; i++) {
            System.out.println("Number :" + i + " :" + resultA.test(i));
        }
    }

    public static void testCartPro() {
        Predicate<Integer> memA = TestReClosures::multOfTwo;
        Predicate<Integer> memB = TestReClosures::multOfThree;
        BiPredicate<Integer, Integer> result = RecClosures.cartesianProduct(memA, memB);
        Predicate<Integer> memC = TestReClosures::lessThan10;
        Predicate<Integer> memD = TestReClosures::greaterThan10;
        BiPredicate<Integer, Integer> resultA = RecClosures.cartesianProduct(memC, memD);

        System.out.println("testing x % 2 == 0 and x % 3 == 0");
        for (int i = 1; i <= 20; i++) {
            for (int r = 1; r <= 20; r++) {
                System.out.println("Numbers :" + i + "and " + r + " :" + result.test(i, r));
            }
        }

        System.out.println("Testing x < 10 and x > 10");
        for (int i = 1; i <= 20; i++) {
            for (int r = 1; r <= 20; r++) {
                System.out.println("Numbers :" + i + " and " + r + " :" + resultA.test(i, r));
            }
        }
    }

    public static void testEnumUnion() {
        System.out.println("The union between x -> x * 2 and x -> x * 3");
        for (int i = 0; i < 10; i++) {
            System.out.println("Number: " + i + " : " + RecClosures.enumUnion(i, multTwo, multThree));
        }
    }

    public static void testEnumDiff() {
        System.out.println("The Differance between x -> x * 2 and x -> x * 3");
        for (int i = 0; i < 10; i++) {
            System.out.println("Number: " + i + " : " + RecClosures.enumDifferance(i, multTwo, multThree));
        }
    }

    public static void testEnumInter() {
        System.out.println("The intersection between x -> x * 2 and x -> x * 3");
        for (int i = 0; i < 10; i++) {
            System.out.println("Number: " + i + " : " + RecClosures.enumDifferance(i, multTwo, multThree));
        }
    }

    public static void main(String[] args) {
        System.out.println("\nThese tests are for union");
        testUnion();
        System.out.println("\nThese tests are for intersection");
        testIntersection();
        System.out.println("\nThese tests are for differance");
        testDifferance();
        System.out.println("\nThese tests are for the cartesian product");
        testCartPro();
        System.out.println("\nThese tests if the following numbers are solutions in the enumeraded sets for the folowing union");
        testEnumUnion();
        System.out.println("\nThese tests if the following numbers are solutionsin the enumeraded sets for the folowing difference");
        testEnumDiff();
        System.out.println("\nThese tests if the following numbers are solutionsin the enumeraded sets for the folowing intersection");
        testEnumInter();
    }
}
