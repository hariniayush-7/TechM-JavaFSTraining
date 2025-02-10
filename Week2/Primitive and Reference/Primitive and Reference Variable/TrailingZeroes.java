package basics;
import java.util.Scanner;

	public class TrailingZeroes {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter a number: ");
	        int number = scanner.nextInt();
	        int trailingZeroes = countTrailingZeroes(number);
	        System.out.println("Trailing zeroes in " + number + "! is: " + trailingZeroes);
	    }

	    public static int countTrailingZeroes(int n) {
	        int count = 0;
	        while (n >= 5) {
	            n /= 5;
	            count += n;
	        }
	        return count;
	    }
	}



