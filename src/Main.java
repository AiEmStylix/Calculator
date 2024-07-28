import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "(-2+3+4 * 5)*5-5;";

        //Delay time when exit the program
        int delay = 2000;

        int index = 0;
        List<String> tokens = new ArrayList<>();
        List<String> prefix = new ArrayList<>();
        Calculator calculator = new Calculator();
        //The main loop
//            while (true) {
//                System.out.print("[" + index + "]: ");
//                //input = scanner.nextLine();
//                if (input.equalsIgnoreCase("exit")) {
//                    break;
//                }
//                tokens = Calculator.tokenize(input);
//                index++;
//            }
        tokens = Calculator.tokenize(input);
        prefix = calculator.ShuntingYard(tokens);
        System.out.println("Tokens: " + tokens);
        System.out.println("Preflix: " + prefix);
            System.out.println(tokens);
            //Exit time delay
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }

            scanner.close();

        }
    }
