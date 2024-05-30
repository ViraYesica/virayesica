package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        // Main loop to continue calculations until the user chooses to exit
        while (continueCalculation) {
            int choice = -1;
            boolean validChoice = false;
            
            // Loop to get a valid choice from the user
            while (!validChoice) {
                try {
                    System.out.println("Advanced Calculator");
                    System.out.println("Choose an operation: ");
                    System.out.println("1. Addition (+)");
                    System.out.println("2. Subtraction (-)");
                    System.out.println("3. Multiplication (*)");
                    System.out.println("4. Division (/)");
                    System.out.println("5. Modulus (%)");
                    System.out.println("6. Exponentiation (^)");
                    System.out.println("7. Square Root (sqrt)");
                    System.out.println("8. Sine (sin)");
                    System.out.println("9. Cosine (cos)");
                    System.out.println("10. Tangent (tan)");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();  // Read user choice
                    if (choice >= 1 && choice <= 10) {
                        validChoice = true;  // If choice is valid, exit loop
                    } else {
                        throw new IllegalArgumentException("Invalid choice.");  // Handle invalid choice
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Input must be a number.");
                    scanner.next(); // Clear the invalid input
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            double num1 = 0, num2 = 0, result = 0;

            // Get numbers based on the operation chosen
            try {
                if (choice >= 1 && choice <= 6) {
                    num1 = getNumber(scanner, "Enter the first number: ");
                    num2 = getNumber(scanner, "Enter the second number: ");
                } else if (choice >= 7 && choice <= 10) {
                    num1 = getNumber(scanner, "Enter the number: ");
                }

                // Perform the calculation based on the user's choice
                switch (choice) {
                    case 1:
                        result = num1 + num2;  // Addition
                        break;
                    case 2:
                        result = num1 - num2;  // Subtraction
                        break;
                    case 3:
                        result = num1 * num2;  // Multiplication
                        break;
                    case 4:
                        if (num2 != 0) {
                            result = num1 / num2;  // Division
                        } else {
                            throw new ArithmeticException("Division by zero is not allowed.");
                        }
                        break;
                    case 5:
                        result = num1 % num2;  // Modulus
                        break;
                    case 6:
                        result = Math.pow(num1, num2);  // Exponentiation
                        break;
                    case 7:
                        if (num1 >= 0) {
                            result = Math.sqrt(num1);  // Square Root
                        } else {
                            throw new ArithmeticException("Square root of a negative number is not allowed.");
                        }
                        break;
                    case 8:
                        result = Math.sin(Math.toRadians(num1));  // Sine
                        break;
                    case 9:
                        result = Math.cos(Math.toRadians(num1));  // Cosine
                        break;
                    case 10:
                        result = Math.tan(Math.toRadians(num1));  // Tangent
                        break;
                }

                System.out.println("Result: " + result);  // Display result

            } catch (InputMismatchException e) {
                System.out.println("Error: Input must be a number.");
                scanner.next(); // Clear the invalid input
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }

            // Ask the user if they want to perform another calculation
            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Do you want to perform another calculation? (yes/no): ");
                String userResponse = scanner.next().trim().toLowerCase();
                if (userResponse.equals("yes")) {
                    validResponse = true;
                    continueCalculation = true;  // Continue calculations
                } else if (userResponse.equals("no")) {
                    validResponse = true;
                    continueCalculation = false;  // Exit loop and end program
                } else {
                    System.out.println("Error: Please enter 'yes' or 'no'.");
                }
            }
        }

        System.out.println("Thank you for using this calculator. Goodbye!");  // Exit message
    }

    // Helper method to get a valid number from the user
    private static double getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Error: Input must be a number.");
            scanner.next(); // Clear the invalid input
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }
}
