package basics;

public class PrimitiveReferenceDemo {
	
	    public static void main(String[] args) {
	        int number = 10;
	        int[] array = {1, 2, 3};

	        System.out.println("Before method call:");
	        System.out.println("Integer: " + number);
	        System.out.print("Array: ");
	        printArray(array);

	        modifyVariables(number, array);

	        System.out.println("After method call:");
	        System.out.println("Integer: " + number);
	        System.out.print("Array: ");
	        printArray(array);
	    }

	    public static void modifyVariables(int num, int[] arr) {
	        num = 20;
	        arr[0] = 99;
	    }

	    public static void printArray(int[] arr) {
	        for (int value : arr) {
	            System.out.print(value + " ");
	        }
	        System.out.println();
	    }
	}



