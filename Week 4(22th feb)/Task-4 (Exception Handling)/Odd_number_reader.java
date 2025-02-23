package task_4;

public class Odd_number_reader {
    
    public void validateEvenNumber(int number) throws OddNumberException {
        if (number % 2 != 0) {
            throw new OddNumberException("The number " + number + " is odd. Only even numbers are allowed.");
        }
        System.out.println("The number " + number + " is valid.");
    }

    public static void main(String[] args) {
        Odd_number_reader validator = new Odd_number_reader();
        
        try {
            validator.validateEvenNumber(5); 
        } catch (OddNumberException e) {
            System.err.println(e.getMessage());
        }

        try {
            validator.validateEvenNumber(4); 
        } catch (OddNumberException e) {
            System.err.println(e.getMessage());
        }
    }
}