package task_1;

public class Alternative_no {
	public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] alternative_no = new int[(originalArray.length + 1) / 2];

        for (int i = 0, j = 0; i < originalArray.length; i += 2, j++) {
        	alternative_no [j] = originalArray[i];
        }

        System.out.println("Alternative number in Array: ");
        for (int element :alternative_no ) {
            System.out.print(element + " ");
        }
    }

}
