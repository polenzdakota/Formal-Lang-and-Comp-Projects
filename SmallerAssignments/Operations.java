
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * Set of Operations to be used on sets and maps
 *
 * @author Dakota Polenz
 */
public class Operations {

    private static final Map<Integer, String> unicodes = setUnicodeMap();

    /**
     * Finds and returns a set of all intersecting elements in two sets
     *
     * @param <T> Generic type for the elements in each set
     * @param a The first set
     * @param b The second set
     * @return The set of all elements that are intersecting elements in the
     * sets
     */
    public static <T> Set<T> intersect(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<T>();
        for (T element : a) {
            if (b.contains(element)) {
                intersection.add(element);
            }
        }
        return intersection;
    }

    /**
     * Finds and returns all values in two sets
     *
     * @param <T> Generic type of the elements in each set
     * @param a The first set
     * @param b The second set
     * @return The set of all elements that are in each set
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> union = new HashSet<>();
        union.addAll(a);
        for (T element : b) {
            if (!a.contains(element)) {
                union.add(element);
            }
        }
        return union;
    }

    /**
     * Finds and returns the set made by the differance of the provided sets
     *
     * @param <T> Generic type used for the elements of the sets
     * @param a The first set
     * @param b The second set
     * @return The set made by the differance of the two sets
     */
    public static <T> Set<T> diff(Set<T> a, Set<T> b) {
        Set<T> differance = new HashSet<>();
        differance.addAll(a);
        for (T element : a) {
            if (b.contains(element)) {
                differance.remove(element);
            }
        }
        return differance;
    }

    /**
     * Finds whether or not the first provided set is a subset of the second
     * provided set
     *
     * @param <T> Generic type used as the elements for each set
     * @param a The first set
     * @param b The second st
     * @return true if a is a subset of b
     */
    public static <T> boolean subset(Set<T> a, Set<T> b) {
        for (T element : a) {
            if (!b.contains(element)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Finds and returns the power set of a given set
     *
     * @param <T> Generic type used for elements in given set
     * @param a The given set
     * @return A set of all possible sets of a
     */
    public static <T> Set<Set<T>> powers(Set<T> a) {
        Set<Set<T>> rs = new HashSet<Set<T>>();
        if (a.isEmpty()) {
            rs.add(new HashSet<T>());
            return rs;
        } else {
            List<T> elements = new ArrayList<>(a);
            T head = elements.get(0);
            Set<T> tail = new HashSet<T>(elements.subList(1, elements.size()));
            Set<Set<T>> tailSubsets = powers(tail);
            for (Set<T> sets : tailSubsets) {
                Set<T> subset = new HashSet<T>();
                subset.add(head);
                subset.addAll(sets);
                rs.add(subset);
                rs.add(sets);
            }
            return rs;
        }
    }

    /**
     * Returns a set with the values that make a given function false
     *
     * @param <T> Generic type used for elements in the set
     * @param a Given set
     * @param f Function given
     * @return A set with values that make the given function false fileterd
     */
    public static <T> Set<T> filter(Set<T> a, Predicate<T> f) {
        Set<T> result = new HashSet<>();
        result.addAll(a);
        for (T element : a) {
            if (!f.test(element)) {
                result.remove(element);
            }
        }
        return result;
    }

    /**
     * Returns a set with each value of a given set applied to a given function
     *
     * @param <T> Generic type used for the elements in the set
     * @param a The given set
     * @param f The given function
     * @return A set with each value of a given set applied to a given function
     */
    public static <T> Set<T> map(Set<T> a, UnaryOperator<T> f) {
        Set<T> result = new HashSet<T>();
        for (T element : a) {
            result.add(f.apply(element));
        }
        return result;
    }

    /**
     * Method that sets all values in the unicodes map
     *
     * @return A set with all unicode values set
     */
    public static Map<Integer, String> setUnicodeMap() {
        Map<Integer, String> unicodes = new HashMap();
        int offset = 30;
        for (int i = 0; i <= 9; i++) {
            String uni = "//u00" + (i + offset);
            unicodes.put(i, uni);
        }
        return unicodes;
    }

    /**
     * Gets the unicode value for the provided digit
     *
     * @param digit the digit provided
     * @return a String of the unicode for the given digit
     */
    public static String getCode(int digit) {
        return unicodes.get(digit);
    }
}
