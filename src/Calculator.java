import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static List<String> tokenize(String expression) {
        StringBuilder sb = new StringBuilder();
        List<String> tokens = new ArrayList<>();
        boolean lastWasOperator = true; //Handle negative number

        for (char c : expression.toCharArray()) {
            //Skip the whitespace character
            if (Character.isWhitespace(c)) {
                continue;
            }

            //Tokenize the digit and operator
            if (Character.isDigit(c) || c == '.') {
                sb.append(c);
                lastWasOperator = false;
            } else if (isOperator(c) || c == '(' || c == ')') {
                if (!sb.isEmpty()) {
                    tokens.add(String.valueOf(sb));
                    sb.setLength(0);
                }
            }

        }
        if (!sb.isEmpty()) {
            tokens.add(String.valueOf(sb));
            sb.setLength(0);
        }
        return tokens;
    }

    public static boolean isOperator (char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }
}
