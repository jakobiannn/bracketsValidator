import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final List<String> cases = new ArrayList<>(
            Arrays.asList("(()", ")()())", ")(()())", ")(", "())(()())(()")
    );

    public static void main(String[] args) {
        Validator validator = new Validator();
        for (String currentCase: cases) {
            validator.validateBrackets(currentCase);
        }
    }
}
