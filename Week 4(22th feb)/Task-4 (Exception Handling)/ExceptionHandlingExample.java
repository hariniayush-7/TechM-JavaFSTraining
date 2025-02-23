package task_4;
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            throw new ArithmeticException("This is an arithmetic exception.");
        } 
        catch (ArithmeticException e) {
            System.out.println("Caught an exception: " + e.getMessage());
        } 
        finally {
            System.out.println("Execution of the try-catch block is complete.");
        }
    }
}
