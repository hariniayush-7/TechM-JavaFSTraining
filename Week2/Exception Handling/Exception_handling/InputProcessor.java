package basics;


	import java.util.InputMismatchException;
	import java.util.Scanner;

	public class InputProcessor {

	    public static void main(String[] args) {
	        processInput();
	    }

	    public static void processInput() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Please enter a number: ");
	        
	        try {
	            double number = scanner.nextDouble();
	            if (number == 0) {
	                throw new ArithmeticException("Division by zero is not allowed.");
	            }
	            double reciprocal = 1 / number;
	            System.out.println("The reciprocal of " + number + " is " + reciprocal);
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a numerical value.");
	        } catch (ArithmeticException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            scanner.close();
	        }
	    }
	}



