import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculator {
    public static List<String> tokenize(String expression) {
        StringBuilder sb = new StringBuilder();
        List<String> tokens = new ArrayList<>();
        boolean expectOperator = false; //Flag to expect operator after number

        //Iterate through the expression
        for (char c : expression.toCharArray()) {

            //Skip the whitespace character
            if (Character.isWhitespace(c)) {
                continue;
            }

            //Tokenize the digit and operator
            if (Character.isDigit(c) || c == '.') {
                sb.append(c);
                expectOperator = false;
            } else {
                if (!sb.isEmpty()) {
                    tokens.add(sb.toString());
                    sb.setLength(0);
                    expectOperator = true;
                }
                if (!expectOperator && c == '-') {
                    tokens.add("u-");
                } else if (isBinaryOperator(c)) {
                    tokens.add(String.valueOf(c));
                    expectOperator = false;
                } else if (c == '(' || c == ')') {
                    tokens.add(String.valueOf(c));
                    expectOperator = c == ')'; //Set flag to false if operator is )
                }
            }

        }
        //Add the last digit into array
        if (!sb.isEmpty()) {
            tokens.add(String.valueOf(sb));
            sb.setLength(0);
        }
        return tokens;
    }
    //Check if token is binary operator
    public static boolean isBinaryOperator (char operator) {
        return operator == '+' || operator == '-' || operator == '*' || operator == '/';
    }

    public List<String> ShuntingYard (List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (var token : tokens) {
            if (isNumber(token)) {
                output.add(token);
            }
            //If finding (, push it to list
            else if (token.equals("(")){
                operators.push(token);
            }
            else if (token.equals(")")) {
                //Adding output from parenthesis
                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                //Remove "(" after pop all operator
                if (!operators.isEmpty() && operators.peek().equals("(")) {
                    operators.pop();
                }
            }
            //Check if token equal unary minus or binary operator
            else if (token.equals("u-") || isBinaryOperator(token.charAt(0)))
            {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) {
                    output.add(operators.pop());
                }
                operators.push(token);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        return output;
    }

    //public

    //Precedence of each operator
    private static int precedence (String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "u-": //Grant highest precedence for unary minus
                return 3;
            default:
                return 0;
        }
    }
    //Check if token is number
    private static boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double evaluate (List<String> Postfix) {
        Stack<Double> stack = new Stack<>();
        for (String token : Postfix) {
            if (isNumber(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                if (token.equals("u-")) {
                    stack.push(-b);
                } else {
                    double a = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(a + b);
                            break;
                        case "-":
                            stack.push(a - b);
                            break;
                        case "*":
                            stack.push(a * b);
                            break;
                        case "/":
                            stack.push(a / b);
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }
}
