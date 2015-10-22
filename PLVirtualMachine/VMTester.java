
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dakota
 */
public class VMTester {

    public static void subtract(int x, int y) throws Exception {
        VM subVm = new VM();
        String loadN = "load x " + x;
        String loadM = "load y " + y;
        subVm.add(loadN);
        subVm.add(loadM);
        subVm.add("load v x");
        subVm.add("loop y");
        subVm.add("load w 0");
        subVm.add("load t v");
        subVm.add("loop t");
        subVm.add("load h w");
        subVm.add("inc w");
        subVm.add("end");
        subVm.add("load f h");
        subVm.add("load v f");
        subVm.add("end");
        subVm.add("load z v");
        subVm.run();
        System.out.println(subVm);

    }

    public static void addTest(int n, int m) throws Exception {
        VM addVm = new VM();
        String firstNum = "load n " + n;
        String result = "load z " + m;
        addVm.add(firstNum);
        addVm.add(result);
        addVm.add("loop n");
        addVm.add("inc z");
        addVm.add("end");
        addVm.run();
        System.out.println(addVm);
    }

    public static void mult(int n, int m) throws Exception {
        VM multVm = new VM();
        String loadN = "load n " + n;
        String loadM = "load m " + m;
        String loadW = "load w " + 0;
        String addInc = "load t " + 0;
        multVm.add(loadN);
        multVm.add(loadM);
        multVm.add(loadW);
        multVm.add(addInc);
        multVm.add("loop n");
        multVm.add("load t m");
        multVm.add("loop w");
        multVm.add("inc t");
        multVm.add("end");
        multVm.add("load w t");
        multVm.add("load t 0");
        multVm.add("end");
        multVm.run();
        System.out.println(multVm);

    }

    public static void varAndExcTest() throws Exception {
        VM addVm = new VM();
        String firstNum = "load n " + 5;
        String result = "load z " + 6;
        addVm.add(firstNum);
        addVm.add(result);
        addVm.add("loop n");
        addVm.add("inc z");
        addVm.add("end");
        addVm.run();
        String str = addVm.getExecuteCounter() + "\n" + addVm.variablesUsed();
        System.out.println(str);
    }
    
    public static void givenTest() {
        try {
            VM vm = new VM();
            vm.add("load x 10");
            vm.add("load y 5");
            vm.add("loop x");
            vm.add("inc y");
            vm.add("end");
            vm.add("goto AAA");
            vm.add("inc y");
            vm.add("AAA: inc y");
            vm.run();
            System.out.println(vm);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void fileTest(String fileName) throws IOException, Exception {
        VM cmpVm = new VM();
        cmpVm.compile(fileName);
        cmpVm.run();
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Add Test 4 + 3");
        addTest(4, 3);
        System.out.print("\n");
        System.out.println("Add Test 10 + 3");
        addTest(10, 3);
        System.out.print("\n");
        System.out.println("Add Test 2 + 5");
        addTest(2, 5);
        System.out.print("\n");
        System.out.println("Variables and execution counter test");
        varAndExcTest();
        System.out.print("\n");
        System.out.println("Mult Test 2 * 3 (W is result)");
        mult(2, 3);
        System.out.print("\n");
        System.out.println("Mult Test 10 * 6 (W is result)");
        mult(10, 6);
        System.out.print("\n");
        System.out.println("Mult Test 1 * 5 (W is result)");
        mult(1, 5);
        System.out.print("\n");

        System.out.println("Sub test 5-3 (Z is result)");
        subtract(5, 3);
        System.out.print("\n");
        System.out.println("Sub test 10-3 (Z is result)");
        subtract(10, 3);
        System.out.print("\n");
        System.out.println("Sub test 18-5 (Z is result)");
        subtract(18, 5);
        System.out.print("\n");
        System.out.println("Sub test 5-6 (Z is result)");
        subtract(5, 6);
        System.out.print("\n");
        
        System.out.println("Given Test");
        givenTest();
    }
}
