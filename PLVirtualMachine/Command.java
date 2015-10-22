
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dakota
 */
public class Command {

    private String label;
    private String opcode;
    private String arg1;
    private String arg2;
    private int target;
    private int pc;
    private int count;
    //private String te = "([A-Z]+:{1}\\s*){0,1}(load\\s*|goto\\s*|inc\\s*|loop\\s*|end\\s*){0,1}([a-z]+|[A-Z]+\\s*){0,1}([0-9]+\\s*){0,1}";
    private String test = "([A-Z]+:{1}\\s*){0,1}(load\\s*|goto\\s*|inc\\s*|loop\\s*|end\\s*){0,1}([a-z]\\s*|[A-Z]+\\s*){0,1}([0-9]+|[a-z]+){0,1}";
    private Pattern cmmdPattern = Pattern.compile(test);

    public Command(String cmmd, int passedPC) {
        Matcher m = cmmdPattern.matcher(cmmd);
        if (m.matches()) {
            if (m.group(1) != null) {
                label = m.group(1).trim();
                label = label.substring(0, label.length() - 1);
            }
            if (m.group(2) != null) opcode = m.group(2).trim();
            if (m.group(3) != null) arg1 = m.group(3).trim();
            if (m.group(4) != null) arg2 = m.group(4).trim();
        } else {
            System.out.print("failed at:" + cmmd);
        }
        pc = passedPC;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the opcode
     */
    public String getOpcode() {
        return opcode;
    }

    /**
     * @param opcode the opcode to set
     */
    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    /**
     * @return the arg1
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * @param arg1 the arg1 to set
     */
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    /**
     * @return the arg2
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * @param arg2 the arg2 to set
     */
    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    /**
     * @return the target
     */
    public int getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(int target) {
        this.target = target;
    }
    
    public int getPC() {
        return pc;
    }
    
    @Override
    public String toString() {
        String ret = "";
        String strlabel = "Label = " + getLabel() + "\n";
        String stropcode = "Opcode = " + getOpcode() + "\n";
        String strarg1 = "arg1 = " + getArg1() + "\n";
        String strarg2 = "arg2 = " + getArg2() + "\n";
        String strtarget = "Target = " + getTarget() + "\n";
        String strpc = "pc = " + getPC() + "\n";
        ret = strlabel + stropcode + strarg1 + strarg2 + strtarget + strpc;
        return ret;
    }

}
