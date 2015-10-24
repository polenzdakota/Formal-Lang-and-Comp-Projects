
import java.util.ArrayList;

/**
 * This class includes a variety of methods that return functions used to
 * specify grammars for the parser class
 *
 * @author Dakota
 */
public class Combinators {

    /**
     * Takes two parsers and returns an option between the two parsers
     *
     * @param p1 The first parser
     * @param p2 The second parser
     * @return A parser that allows for the possibility of a result to be true
     * for either parser.
     */
    public static Parser alt(Parser p1, Parser p2) {
        Parser parser = new Parser();
        parser.setParser(
                result -> {
                    if (result.isFail()) {
                        return result;
                    }
                    Choice answer = new Choice();
                    ArrayList<String> tmp = new ArrayList<>(result.unseen);
                    answer.setChoice(p1.apply(result));
                    if (answer.getChoice().isFail()) {
                        result.unseen = new ArrayList<>(tmp);
                        answer.setChoice(p2.apply(result));
                    }
                    if (answer.getChoice().isFail()) {
                        return answer.getChoice();
                    }
                    answer.unseen = new ArrayList<>(answer.getChoice().unseen);
                    return answer;
                });
        return parser;
    }

    /**
     * Takes two parser and returns a sequence between the two parsers
     * @param p1 the first parser
     * @param p2 the second parser
     * @return A parser where a result must be passed through both parsers
     */
    public static Parser seq(Parser p1, Parser p2) {
        Parser parser = new Parser();
        parser.setParser(
                result -> {
                    if (result.isFail()) {
                        return result;
                    } else {
                        Concatenation answer = new Concatenation();
                        answer.setChild1(p1.apply(result));
                        if (answer.getChild1().isFail()) {
                            return answer.getChild1();
                        }

                        answer.unseen = new ArrayList<>(answer.getChild1().unseen);
                        answer.setChild2(p2.apply(answer.getChild1()));
                        if (answer.getChild2().isFail()) {
                            return answer.getChild2();
                        }
                        answer.unseen = new ArrayList<>(answer.getChild2().unseen);
                        return answer;
                    }
                });
        return parser;
    }

    /**
     * Takes a parser and allows for repeated instances of a result
     * @param p the given parser
     * @return A parser that allows for repeated instances of a result
     */
    public static Parser rep(Parser p) {
        Parser parser = new Parser();
        parser.setParser(
                result -> {
                    if (result.isFail()) {
                        return result;
                    } else {
                        Iteration answer = new Iteration();
                        result = p.apply(result);
                        while (!result.isFail()) {
                            answer.addIteration(result);
                            result = p.apply(result);
                        }
                        answer.unseen = new ArrayList<>(result.unseen);
                        return answer;
                    }
                });
        return parser;
    }

    /**
     * Takes a parser and allows for the option for a result to be true for the 
     * given parser
     * @param p the given parser
     * @return A parser where a result set includes an optional segment
     */
    public static Parser opt(Parser p) {
        Parser parser = new Parser();
        parser.setParser(
                result -> {
                    if (result.isFail()) {
                        return result;
                    } else {
                        ArrayList<String> tmp = new ArrayList<>(result.unseen);
                        Option answer = new Option();
                        answer.setChild(p.apply(result));
                        if (answer.isFail()) {
                            answer.unseen = new ArrayList<>(tmp);
                        }
                        return answer;
                    }
                });
        return parser;
    }

    /**
     * Returns a parser that checks a regular expression against literals and sets
     * the nodes to the next unseen string if it matches the regular expression
     * @param regex The given regular expression
     * @return a parser that includes the result set with the next set of literals
     * provided.
     */
    public static Parser regEx(String regex) {
        Parser parser = new Parser();
        parser.setParser(
                result -> {
                    Literal answer = new Literal();
                    if (result.isFail()) {
                        return result;
                    }
                    if (result.unseen.isEmpty()) {
                        answer.setFail(true);
                        return answer;
                    }
                    String nextUnseen = result.unseen.get(0);
                    if (nextUnseen.matches(regex)) {
                        answer.setToken(nextUnseen);
                        result.unseen.remove(0);
                        answer.unseen = new ArrayList<>(result.unseen);
                    } else {
                        answer.setFail(true);
                        answer.unseen = new ArrayList<>(result.unseen);
                    }
                    return answer;
                });
        return parser;
    }
}
