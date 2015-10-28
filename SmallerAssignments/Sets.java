
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dakota Polenz
 */
public class Sets {

    /**
     * Finds and returns a set of all intersecting elements in two sets
     * @param <T> Generic type for the elements in each set
     * @param a The first set
     * @param b The second set
     * @return The set of all elements that are intersecting elements in the sets
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
     *  Finds and returns all values in two sets
     * @param <T> Generic type of the elements in each set
     * @param a The first set
     * @param b The second set
     * @return The set of all elements that are in each set
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> union = a;
        for (T element : b) {
            if (!a.contains(element)) {
                union.add(element);
            }
        }
        return union;
    }

    /**
     *  Finds and returns the set made by the differance of the provided sets
     * @param <T> Generic type used for the elements of the sets
     * @param a The first set
     * @param b The second set
     * @return  The set made by the differance of the two sets
     */
    public static <T> Set<T> diff(Set<T> a, Set<T> b) {
        Set<T> differance = a;
        for (T element : a) {
            if (b.contains(element)) {
                differance.remove(element);
            }
        }
        return differance;
    }

    /**
     * Finds whether or not the first provided set is a subset of the second provided set
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
}