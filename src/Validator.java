import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Validator {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    public void validateBrackets(String brackets) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> range = new ArrayList<>(IntStream.range(0, brackets.length()).boxed().toList());
        fillAnswer(range, brackets, answer);
        if (answer.isEmpty()) {
            System.out.println(0);
            return;
        }
        System.out.printf("%d - ", answer.size());
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            System.out.printf("%s", brackets.charAt(answer.get(i)));
        }
        System.out.println();
    }

    private void fillAnswer(List<Integer> range, String brackets, List<Integer> answer) {
        boolean potentialDecision = false;
        int i = 0;
        while (i < range.size() - 1) {
            char currentChar = brackets.charAt(range.get(i));
            if (LEFT_BRACKET == currentChar && RIGHT_BRACKET == brackets.charAt(range.get(i + 1))) {
                answer.add(range.get(i));
                answer.add(range.get(i + 1));
                range.remove(i);
                range.remove(i);
                potentialDecision = true;
            } else i++;
        }
        if (potentialDecision) {
            fillAnswer(range, brackets, answer);
        }
    }
}