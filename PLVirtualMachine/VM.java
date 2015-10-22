
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Dakota
 */
public class VM {

    private Integer pc;
    private ArrayList<Command> program;
    private Map<String, Integer> vars;
    private int executeCounter = 0;

    public VM() {
        program = new ArrayList();
        vars = new HashMap();
        pc = 0;
    }

    public void add(String cmmd) {
        Command cmdAdded = new Command(cmmd, pc++);
        program.add(cmdAdded);
    }

    public void resolveLabels() {
        Stack<Command> loopStack = new Stack<Command>();
        Map<String, Integer> targets = new HashMap<String, Integer>();
        for (Command cmmd : program) {
            if (cmmd.getLabel() != null) {
                int cmmdPC = cmmd.getPC();
                String cmmdLabel = cmmd.getLabel();
                targets.put(cmmdLabel, cmmdPC);
            }
            if (cmmd.getOpcode().equals("loop")) {
                loopStack.push(cmmd);
            }
            if (cmmd.getOpcode().equals("end")) {
                Command looped = loopStack.pop();
                looped.setTarget(cmmd.getPC());
                cmmd.setTarget(looped.getPC());
            }
        }
        for (Command cmmd : program) {
            if (cmmd.getOpcode().equals("goto")) {
                Integer gotoTarget = targets.get(cmmd.getArg1());
                cmmd.setTarget(gotoTarget);
            }
        }
    }

    public void compile(String fileName) throws FileNotFoundException, IOException {
        String line;
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            String added = line.trim();
            add(added);
        }
    }

    public void execute(Command cmmd) throws Exception {
        if (cmmd.getOpcode().equals("load")) {
            String var = cmmd.getArg1();
            String arg = cmmd.getArg2();
            Integer argInt;
            try {
                argInt = Integer.parseInt(arg);
            } catch (NumberFormatException e) {
                argInt = vars.get(arg);
            }
            vars.put(var, argInt);
        } else if (cmmd.getOpcode().equals("inc")) {
            String var = cmmd.getArg1();
            Integer varInt = vars.get(var);
            varInt++;
            vars.put(var, varInt);
        } else if (cmmd.getOpcode().equals("goto")) {
            pc = cmmd.getTarget();
        } else if (cmmd.getOpcode().equals("loop")) {
            String var = cmmd.getArg1();
            Integer varInt = vars.get(var);
            if (varInt == 0) {
                pc = cmmd.getTarget() + 1;
            } else {
                varInt--;
                vars.put(var, varInt);
            }
        } else if (cmmd.getOpcode().equals("end")) {
            pc = cmmd.getTarget();
        } else {
            throw new Exception("Unreconized operation");
        }
    }

    public void run() throws Exception {
        resolveLabels();
        pc = 0;
        while (pc < program.size()) {
            execute(program.get(pc++));
            executeCounter++;
        }
    }

    public String getExecuteCounter() {
        return "Instructions Executed: " + executeCounter;
    }

    public String variablesUsed() {
        return "Number of variables used: " + vars.size();
    }

    @Override
    public String toString() {
        String ret = "";
        String strPC = "pc = " + pc + "\n";
        String strVARS = "vars = " + vars.toString();
        ret = strPC + strVARS;
        return ret;
    }
}
