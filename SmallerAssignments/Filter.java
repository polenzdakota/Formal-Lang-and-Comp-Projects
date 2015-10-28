
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 *
 * @author Dakota
 */
public class Filter {
    
    /**
     * Returns a set with the values that make a given function false
     * @param <T> Generic type used for elements in the set
     * @param a Given set
     * @param f Function given
     * @return A set with values that make the given function false fileterd
     */
    public static <T> Set<T> filter(Set<T> a, Predicate<T> f) {
        Set<T> result = a;
        for(T element: result) {
            if (!f.test(element)) {
                a.remove(element);
            }
        }
        return result;
    }
    /**
     * Returns a set with each value of a given set applied to a given function
     * @param <T> Generic type used for the elements in the set
     * @param a The given set
     * @param f The given function
     * @return A set with each value of a given set applied to a given function
     */
    public static <T> Set<T> map(Set<T> a, UnaryOperator<T> f) {
        Set<T> result = new HashSet<T>();
        for(T element: a) {
            result.add(f.apply(element));
        }
        return result;
    }
}