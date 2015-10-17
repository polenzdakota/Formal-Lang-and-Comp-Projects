
/**
 *
 * @author Dakota
 */
public class TuringMachineTester {

    public static void testAdd() {
        Tape tape = new Tape("1111101111110");
        TuringMachine tm = new TuringMachine(tape);
        System.out.println(tape.toString());
        Trigger first = new Trigger(0, '1');
        Trigger second = new Trigger(0, '0');
        Trigger third = new Trigger(1, '0');
        Trigger fourth = new Trigger(1, '1');
        Trigger fifth = new Trigger(2, '0');
        Trigger sixth = new Trigger(2, '1');

        Action afirst = new Action(0, '1', 1);
        Action asec = new Action(1, '0', 1);
        Action athir = new Action(3, '0', 0);
        Action afor = new Action(2, '0', -1);
        Action afive = new Action(0, '1', 1);
        Action asix = new Action(4, '1', 0);

        tm.addStep(first, afirst);
        tm.addStep(second, asec);
        tm.addStep(third, athir);
        tm.addStep(fourth, afor);
        tm.addStep(fifth, afive);
        tm.addStep(sixth, asix);

        tm.addFinalState(3);
        tm.addFinalState(4);
        tm.run();
        System.out.println(tm.toString());
    }

    public static void squared(Tape tape) {
        TuringMachine tm = new TuringMachine(tape);

        Trigger first = new Trigger(0, '1');
        Action aFirst = new Action(1, '%', 1);
        tm.addStep(first, aFirst);
        
        Trigger body = new Trigger(1, '1');
        Action aBody = new Action(1, '1', 1);
        tm.addStep(body, aBody);

        Trigger endBody = new Trigger(1, '0');
        Action endFirstBody = new Action(2, '@', -1);
        tm.addStep(endBody, endFirstBody);

        Trigger back = new Trigger(2, '1');
        Action aBack = new Action(2, '1', -1);
        tm.addStep(back, aBack);

        Trigger backMidMark = new Trigger(2, '@');
        Action aBackMidMark = new Action(2, '@', -1);
        tm.addStep(backMidMark, aBackMidMark);
        
        Trigger frontPercent = new Trigger(2, '%');
        Action aFrontPercent = new Action(3, '%', 1);
        tm.addStep(frontPercent, aFrontPercent);

        Trigger front = new Trigger(2, '#');
        Action aFront = new Action(3, '1', 1);
        tm.addStep(front, aFront);

        Trigger nextCopy = new Trigger(3, '1');
        Action aNextCopy = new Action(4, '#', 1);
        tm.addStep(nextCopy, aNextCopy);

        Trigger copiedBit = new Trigger(4, '1');
        Action aCopiedBit = new Action(4, '1', 1);
        tm.addStep(copiedBit, aCopiedBit);

        Trigger midMark = new Trigger(4, '@');
        Action aMidMark = new Action(4, '@', 1);
        tm.addStep(midMark, aMidMark);

        Trigger toEndOfCopy = new Trigger(4, '0');
        Action aToEndOfCopy = new Action(2, '1', -1);
        tm.addStep(toEndOfCopy, aToEndOfCopy);

        Trigger endOfCopy = new Trigger(3, '@');
        Action aEndOfCopy = new Action(5, '1', -1);
        tm.addStep(endOfCopy, aEndOfCopy);

        tm.addFinalState(5);
        tm.run();
        System.out.println("The solution to n * 2 for the tape is:");
        System.out.println(tm.toString());
    }

    public static void multBy2(Tape tape) {
        TuringMachine tm = new TuringMachine(tape);

        Trigger first = new Trigger(0, '1');
        Action aFirst = new Action(1, '#', 1);
        tm.addStep(first, aFirst);

        Trigger body = new Trigger(1, '1');
        Action aBody = new Action(1, '1', 1);
        tm.addStep(body, aBody);

        Trigger endBody = new Trigger(1, '0');
        Action endFirstBody = new Action(2, '@', -1);
        tm.addStep(endBody, endFirstBody);

        Trigger back = new Trigger(2, '1');
        Action aBack = new Action(2, '1', -1);
        tm.addStep(back, aBack);

        Trigger backMidMark = new Trigger(2, '@');
        Action aBackMidMark = new Action(2, '@', -1);
        tm.addStep(backMidMark, aBackMidMark);

        Trigger front = new Trigger(2, '#');
        Action aFront = new Action(3, '1', 1);
        tm.addStep(front, aFront);

        Trigger nextCopy = new Trigger(3, '1');
        Action aNextCopy = new Action(4, '#', 1);
        tm.addStep(nextCopy, aNextCopy);

        Trigger copiedBit = new Trigger(4, '1');
        Action aCopiedBit = new Action(4, '1', 1);
        tm.addStep(copiedBit, aCopiedBit);

        Trigger midMark = new Trigger(4, '@');
        Action aMidMark = new Action(4, '@', 1);
        tm.addStep(midMark, aMidMark);

        Trigger toEndOfCopy = new Trigger(4, '0');
        Action aToEndOfCopy = new Action(2, '1', -1);
        tm.addStep(toEndOfCopy, aToEndOfCopy);

        Trigger endOfCopy = new Trigger(3, '@');
        Action aEndOfCopy = new Action(5, '1', -1);
        tm.addStep(endOfCopy, aEndOfCopy);

        tm.addFinalState(5);
        tm.run();
        System.out.println("The solution to n * 2 for the tape is:");
        System.out.println(tm.toString());
    }

    public static void haltsIfH(Tape tape) {

        System.out.println("Halts if 0^n10^n method has begun...");

        TuringMachine tm = new TuringMachine(tape);

        Trigger first = new Trigger(0, '1');
        Action aFirst = new Action(1, '@', 1);
        tm.addStep(first, aFirst);

        Trigger finalState = new Trigger(0, '0');
        Action aFinalState = new Action(5, '0', 0);
        tm.addStep(finalState, aFinalState);

        Trigger checkRightZeds = new Trigger(5, '0');
        Action acheckRightZeds = new Action(6, '0', 1);
        tm.addStep(checkRightZeds, acheckRightZeds);

        Trigger checkRightPounds = new Trigger(6, '#');
        Action aCheckRightPounds = new Action(6, '#', 1);
        tm.addStep(checkRightPounds, aCheckRightPounds);

        Trigger notBalanced = new Trigger(6, '1');
        Action aNotBalanced = new Action(6, '1', 0);
        tm.addStep(notBalanced, aNotBalanced);

        Trigger woot = new Trigger(6, '0');
        Action aWoot = new Action(7, '0', 0);
        tm.addStep(woot, aWoot);

        Trigger firstSet = new Trigger(1, '1');
        Action aFirstSet = new Action(1, '1', 1);
        tm.addStep(firstSet, aFirstSet);

        Trigger rightMiddle = new Trigger(1, '0');
        Action aRightMiddle = new Action(2, '0', 1);
        tm.addStep(rightMiddle, aRightMiddle);

        Trigger secSet = new Trigger(2, '0');
        Action aSecSet = new Action(2, '0', 1);
        tm.addStep(secSet, aSecSet);

        Trigger match = new Trigger(2, '1');
        Action aMatch = new Action(3, '#', -1);
        tm.addStep(match, aMatch);

        Trigger matched = new Trigger(2, '#');
        Action aMatched = new Action(2, '#', 1);
        tm.addStep(matched, aMatched);

        Trigger back = new Trigger(3, '1');
        Action aBack = new Action(3, '1', -1);
        tm.addStep(back, aBack);

        Trigger backHash = new Trigger(3, '#');
        Action aBackHash = new Action(3, '#', -1);
        tm.addStep(backHash, aBackHash);

        Trigger backMid = new Trigger(3, '0');
        Action aBackMid = new Action(4, '0', -1);
        tm.addStep(backMid, aBackMid);

        Trigger backFirstSet = new Trigger(4, '1');
        Action aBackFirstSet = new Action(4, '1', -1);
        tm.addStep(backFirstSet, aBackFirstSet);

        Trigger backEndSet = new Trigger(4, '@');
        Action aBackEndSet = new Action(0, '@', 1);
        tm.addStep(backEndSet, aBackEndSet);

        tm.addFinalState(7);

        tm.run();

        System.out.println("The tape provided halts");
    }

    public static void main(String[] args) {
        Tape testTape1 = new Tape("1111");
        Tape testTape2 = new Tape("1000");
        Tape testTape5 = new Tape("1111111111000");
        Tape testTape3 = new Tape("11011");
        Tape testTape4 = new Tape("1111011");
        Tape testTape6 = new Tape("111111111101111111111");
        Tape testTape7 = new Tape("11011111");
        
        System.out.println("test tape mult by 2 for: 1111");
        multBy2(testTape1);
        System.out.println("test tape mult by 2 for: 1000");
        multBy2(testTape2);
        System.out.println("test tape mult by 2 for: 1111111111000");
        multBy2(testTape5);
        System.out.println("test tape 1^n0^n for: 11011 (Will Halt)");
        haltsIfH(testTape3);
        System.out.println("test tape 1^n0^n for: 111111111101111111111 (Will Halt)");
        haltsIfH(testTape6);
        
        
        //These tests will diverge when called!
        System.out.println("test tape 1^n0^n for: 1111011 (Will Diverge)");
        haltsIfH(testTape4);
        System.out.println("Test tape 1^n01^n for: 11011111 (Will Diverge)");
        haltsIfH(testTape7);
        
    }
}
