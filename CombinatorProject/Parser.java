
import java.util.function.UnaryOperator;

/**
 * This class contains the parser for a provided grammar
 * @author Dakota
 */
public class Parser implements UnaryOperator<Result> {
    private UnaryOperator<Result> parser;

    /**
     * Applies a given result to a parser
     * @param result The given result
     * @return A result with the given attributes applied to it 
     */
    @Override
    public Result apply(Result result) {
        return parser.apply(result);
    }
    
    /**
     * Sets the rules for a grammar given a lambda
     * @param given The lambda given
     */
    public void setParser(UnaryOperator<Result> given) {
        this.parser = given;
    }
    
}
