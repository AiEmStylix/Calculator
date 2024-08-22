import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Initialized empty string
        String input = " ";
        //Delay time when exit the program
        int delay = 2000;

        int index = 0;

        //Dynamic Array For Arithmetic Expression
        List<String> tokens = new ArrayList<>();
        List<String> postfix = new ArrayList<>();

        double arithmeticOutput = 0;
        int binaryOutput = 0;

        //Create object
        Calculator calculator = new Calculator();
        BaseConverter baseConverter = new BaseConverter();

        //The main loop
            while (true) {
                System.out.print("In [" + index + "]: ");
                input = scanner.nextLine();

                //Exit when user type exit
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                //Check the input type
                if (baseConverter.isBinary(input)) {
                    binaryOutput = baseConverter.binaryToDecimal(input);
                    System.out.println("Out [" + index + "]: " + binaryOutput);
                } else if (calculator.isArithmetic(input)) {
                    tokens = Calculator.tokenize(input);
                    postfix = calculator.ShuntingYard(tokens);
                    arithmeticOutput = (calculator.evaluate(postfix));
                    System.out.println("Out [" + index + "]: " + arithmeticOutput);
                }
                //Output the result
                index++;
            }

            //Exit time delay
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }

            scanner.close();

        }
    }
