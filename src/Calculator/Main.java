package Calculator;
import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static List<String> operations = new ArrayList<>(List.of("Addition", "Subtraction", "Multiplication", "Division", "Exit"));

    public static boolean isInteger(String input) {
        try  {
            Integer.parseInt(input);
        }  catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String getUserChoice() {

        System.out.print("ENTER YOUR CHOICE: ");
        String choice = input.next();

        if (isInteger(choice) && Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 5) {
            return choice;
        } else {
            System.out.println("Invalid choice. Try again!");
            Interface.clearConsole(500);
            Interface.header("Calculadora", 42);
            Interface.menu(operations);
            Interface.line(42);
            return getUserChoice();
        }
    }

    public static void runOperations(int choice) {
        int result = 0;
        String operation = null;

        if (choice != 5) {
            System.out.print("ENTER THE FIRST NUMBER: ");
            String x = input.next();

            if (isInteger(x)) {
                int numx = Integer.parseInt(x);
                System.out.print("ENTER THE SECOND NUMBER: ");
                String y = input.next();
                if (isInteger(y)) {
                    int numy = Integer.parseInt(y);
                    switch (choice) {
                        case 1:
                            result = Integer.parseInt(x) + Integer.parseInt(y);
                            operation = String.format("%d + %d = %d", numx, numy, result);
                            break;
                        case 2:
                            result = Integer.parseInt(x) - Integer.parseInt(y);
                            operation = String.format("%d - %d = %d", numx, numy, result);
                            break;
                        case 3:
                            result = Integer.parseInt(x) * Integer.parseInt(y);
                            operation = String.format("%d x %d = %d", numx, numy, result);
                            break;
                        case 4:
                            result = Integer.parseInt(x) / Integer.parseInt(y);
                            operation = String.format("%d / %d = %d", numx, numy, result);
                            break;
                    }
                } else {
                    System.out.println("Invalid choice. Try again!");
                    Interface.clearConsole(500);
                    runOperations(choice);
                }
            } else {
                System.out.println("Invalid choice. Try again!");
                Interface.clearConsole(500);
                runOperations(choice);
            }
            Interface.clearConsole(500);

            Interface.line(42);
            Interface.printCentered("OPERATION RESULT", 42);
            Interface.printCentered(operation, 42);
            Interface.line(42);

            System.out.print("PRESS ANYTHING TO CONTINUE..");
            new Scanner(System.in).nextLine();
            Interface.clearConsole(500);

            main(new String[0]);
        } else {
            Interface.clearConsole(500);
            Interface.header("LEAVING..", 42);
        }
    }

    public static void main(String[] args) {
        Interface.header("Calculator", 42);
        Interface.menu(operations);
        Interface.line(42);

        int choice = Integer.parseInt(getUserChoice());
        runOperations(choice);
    }
}