
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author Dakota
 */
public class RecClosures {

    public static Predicate<Integer> union(Predicate<Integer> memA, Predicate<Integer> memB) {
        return (x) -> (memA.test(x) || memB.test(x));
    }

    public static Predicate<Integer> intersection(Predicate<Integer> memA, Predicate<Integer> memB) {
        return (x) -> (memA.test(x) && memB.test(x));
    }

    public static Predicate<Integer> differance(Predicate<Integer> memA, Predicate<Integer> memB) {
        return (x) -> (memA.test(x) && !memB.test(x));
    }

    public static BiPredicate<Integer, Integer> cartesianProduct(Predicate<Integer> memA, Predicate<Integer> memB) {
        return (x, y) -> ((memA.test(x) && memB.test(y))) || ((memA.test(y) && memB.test(x)));
    }

    public static boolean enumUnion(Integer p, Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
        int i = 0;
        while (true) {
            if (Objects.equals(p, enumA.apply(i))) {
                return true;
            }
            if (Objects.equals(p, enumB.apply(i))) {
                return true;
            }
            i++;
            if (i > 50) return false;
        }
    }

    public static boolean intersection(Integer x, Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
        int i = 0;
        while (true) {
            if (Objects.equals(x, enumA.apply(i))) {
                return true;
            }
            if (Objects.equals(x, enumB.apply(i))) {
                return false;
            }
            i++;
            if (i > 50) return false;
        }
    }

    public static boolean enumDifferance(Integer x, Function<Integer, Integer> enumA, Function<Integer, Integer> enumB) {
        int i = 0;
        while(true) {
            if (x == enumA.apply(x) && x == enumA.apply(i)) {
                return false;
            }
            if (x == enumA.apply(i)) {
                return true;
            } else if (x == enumB.apply(i)) {
                return true;
            }
            i++;
            if(i > 50) return false;
        }
    }

    public Function<Integer, Integer> enumCartesianProduct(Function<Integer, Integer> memA, Function<Integer, Integer> memB) {
        return (x) -> {
            return null;
        };
    }

}
