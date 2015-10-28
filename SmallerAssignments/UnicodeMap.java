
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Dakota
 */
public class UnicodeMap {

    private static final Map<Integer, String> unicodes = setUnicodeMap();

    /**
     * Method that sets all values in the unicodes map
     * @return A set with all unicode values set
     */
    public static  Map<Integer, String> setUnicodeMap() {
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
     * @param digit the digit provided
     * @return a String of the unicode for the given digit
     */
    public static String getCode(int digit) {
        return unicodes.get(digit);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            System.out.println("Digit is: " + i + "  Unicode is: " + getCode(i));
        }
    }
}
