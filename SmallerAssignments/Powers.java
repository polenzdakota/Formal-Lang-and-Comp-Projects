import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Dakota
 */
public class Powers {

    /**
     * Finds and returns the power set of a given set
     * @param <T> Generic type used for elements in given set
     * @param a The given set
     * @return A set of all possible sets of a
     */
    public static <T> Set<Set<T>> powers(Set<T> a) {
        return powersHelper(a, a.size(), new HashSet<>());
    }
    
    /**
     * Helper method used to find the power set
     * @param <T> Generic type used for the elements in the given set
     * @param a The given set
     * @param length The length of the current subsets to find
     * @param finalResult The set of all sets found
     * @return A set of all possible sets of a
     */
    public static <T> Set<Set<T>> powersHelper(Set<T> a, int length, Set<Set<T>> finalResult) {
        //BaseCase
        if (length == 0) {
            HashSet<T> empty = new HashSet<>();
            Set<Set<T>> rs = new HashSet<>();
            //Adds empty set
            rs.add(empty);
            return rs;
        } else {
            //Recursive call
            finalResult = powersHelper(a, length - 1, finalResult);
            for(T element: a) {
                //TODO Finds all sets of size length
            }
            return finalResult;
        }
    }
}
