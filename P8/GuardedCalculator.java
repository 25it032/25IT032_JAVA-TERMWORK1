package P8;
import java.util.*;

class DivideByZeroException extends Exception {
    DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean success = false;

        while (!success) {
            try {
                System.out.print("Enter first number: ");
                double num1 = sc.nextDouble();

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.next().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = sc.nextDouble();

                double result;

                if (op == '+') {
                    result = num1 + num2;
                } else if (op == '-') {
                    result = num1 - num2;
                } else if (op == '*') {
                    result = num1 * num2;
                } else if (op == '/') {
                    if (num2 == 0) {
                        throw new DivideByZeroException("Cannot divide by zero.");
                    }
                    result = num1 / num2;
                } else {
                    System.out.println("Invalid operator.");
                    continue;
                }

                System.out.println("Result = " + result);
                success = true;
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter numbers only.");
                sc.nextLine();
            }

            catch (DivideByZeroException e) {
                System.out.println(e.getMessage());
            }

            finally {
                System.out.println("Calculation attempt completed.");
                System.out.println();
            }
        }

        sc.close();
    }
}