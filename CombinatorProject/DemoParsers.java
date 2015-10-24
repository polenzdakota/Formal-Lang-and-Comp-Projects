
/**
 *
 * @author Dakota
 */
public class DemoParsers {

    public static Parser number = Combinators.regEx("[0-9]+");
    public static Parser operator = Combinators.regEx("\\+|\\*|\\-|!|/");
    public static Parser name = Combinators.regEx("[a-zA-Z][a-zA-Z0-9]*");
    public static Parser boole = Combinators.regEx("\\btrue\\b|\\bfalse\\b");
    public static Parser term = new Parser();
    public static Parser product = new Parser();
    public static Parser testRep = new Parser();

    public static Parser operatorExp = Combinators.regEx("\\+|\\*");
    public static Parser exp = new Parser();

    static {
        exp.setParser(
                Combinators.alt(
                        Combinators.seq(
                                number,
                                Combinators.seq(operatorExp, exp)),
                        number));
    }

    static {
        term.setParser(
                Combinators.alt(name, Combinators.alt(number, boole)));
    }

    static {
        product.setParser(
                Combinators.alt(Combinators.seq(term, Combinators.rep(Combinators.seq(operator, term))), term));
    }
    
        public static void testExpParsers() {
        String s = "42";
        test(ExpParsers.number, s);
        s = "29z";
        test(ExpParsers.number, s);
        s = "*";
        test(ExpParsers.operator, s);
        s = "-";
        test(ExpParsers.operator, s);
        s = "42 + 91 * 13 + 2";
        test(ExpParsers.exp, s);
        s = "123";
       test(ExpParsers.exp, s);
        s = "15 * 6 - 10";
        test(ExpParsers.exp, s);
    }

    public static void testNum() {
        String s = "10";
        test(number, s);
        s = "m";
        test(number, s);
        s = "52 q";
        test(number, s);
        s = "t25";
        test(number, s);
    }

    public static void testOp() {
        String s = "+";
        test(operator, s);
        s = "/";
        test(operator, s);
        s = "!";
        test(operator, s);
        s = "q";
        test(operator, s);
    }

    public static void testName() {
        String s = "Dakota";
        test(name, s);
        s = "Rick";
        test(name, s);
        s = "5ick";
        test(name, s);
        s = "Rick32";
        test(name, s);
    }

    public static void testBoole() {
        String s = "true";
        test(boole, s);
        s = "false";
        test(boole, s);
        s = "fail";
        test(boole, s);
    }

    public static void testTerm() {
        String s = "Dakota";
        test(term, s);
        s = "+";
        test(term, s);
        s = "true";
        test(term, s);
        s = "56";
        test(term, s);
        s = "23Dakota";
        test(term, s);
    }

    public static void testProduct() {
        String s = "52";
        test(product, s);
        s = "52 + 5";
        test(product, s);
        s = "x - z";
        test(product, s);
        s = "$$$";
        test(product, s);
        s = "$$$ + 52";
        test(product, s);
    }

    public static void test(Parser p, String s) {
        System.out.println("s = " + s);
        Result tree = p.apply(new Result(s));
        System.out.println("tree = " + tree);
        System.out.println("pending = " + tree.pending() + "\n");
    }

    public static void main(String[] args) {

        System.out.println("+++++++++++++++++++++++++++\nGiven Exp Test: \n");
        testExpParsers();
        System.out.println("+++++++++++++++++++++++++++\nNumber Test: \n");
        testNum();
        System.out.println("+++++++++++++++++++++++++++\nOperator Test: \n");
        testOp();
        System.out.println("+++++++++++++++++++++++++++\nName Test: \n");
        testName();
        System.out.println("+++++++++++++++++++++++++++\nBoole Test: \n");
        testBoole();
        System.out.println("+++++++++++++++++++++++++++\nTerm Test: \n");
        testTerm();
        System.out.println("+++++++++++++++++++++++++++\nProduct Test: \n");
        testProduct();
    }
}
