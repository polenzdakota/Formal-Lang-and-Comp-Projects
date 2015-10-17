
import java.lang.reflect.*;

/**
 *
 * @author Dakota
 */
public class MetaMachine {

    public String execute(String... args) throws Exception {
        if (args.length < 2) {
            throw new Exception("Not enough arguments");
        }
        String className = args[0];
        String methodName = args[1];
        String[] input = new String[args.length - 2];
        for (int i = 2; i < args.length; i++) {
            input[i - 2] = args[i];
        }
        ClassLoader classLoader = MetaMachine.class.getClassLoader();

        try {
            Class<?> metaClass = classLoader.loadClass(className);
            Object t = metaClass.newInstance();
            Method metaMethod = metaClass.getMethod(methodName, String[].class);
            metaMethod.invoke(t, (Object) input);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println(e.toString());
        }
        return "done";
    }
}
