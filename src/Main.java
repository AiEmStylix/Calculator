import java.util.Scanner;
import java.lang.Thread;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        //Delay time when exit the program
        int delay = 2000;

        int index = 0;
        //The main loop
            while (!input.equalsIgnoreCase("exit")) {
                System.out.print("[" + index + "]: ");
                input = scanner.nextLine();
                index++;
            }
            //Wait for 2
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }

            scanner.close();

        }
    }
