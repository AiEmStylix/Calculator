import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        //Delay time when exit the program
        int delay = 2000;

        int index = 0;
        List<String> tokens = new ArrayList<>();
        List<String> postfix = new ArrayList<>();
        double output;
        Calculator calculator = new Calculator();
        //The main loop
            while (true) {
                System.out.print("In [" + index + "]: ");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                tokens = Calculator.tokenize(input);
                postfix = calculator.ShuntingYard(tokens);
                output = calculator.evaluate(postfix);
                //Output the result
                System.out.println("Out [" + index + "]: " + output);
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
