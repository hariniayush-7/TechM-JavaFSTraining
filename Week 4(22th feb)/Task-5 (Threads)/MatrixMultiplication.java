package task_5;
import java.util.Random;

public class MatrixMultiplication {

    private static final int SIZE = 4; 
    private static int[][] matrixA = new int[SIZE][SIZE];
    private static int[][] matrixB = new int[SIZE][SIZE];
    private static int[][] resultMatrix = new int[SIZE][SIZE];

    public static void main(String[] args) {
        initializeMatrices();
        multiplyMatrices();
        printResult();
    }

    private static void initializeMatrices() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixA[i][j] = rand.nextInt(10); // Random values between 0 and 9
                matrixB[i][j] = rand.nextInt(10);
            }
        }
    }

    private static void multiplyMatrices() {
        Thread[] threads = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < SIZE; j++) {
                    for (int k = 0; k < SIZE; k++) {
                        resultMatrix[row][j] += matrixA[row][k] * matrixB[k][j];
                    }
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < SIZE; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult() {
        System.out.println("Matrix A:");
        printMatrix(matrixA);
        System.out.println("Matrix B:");
        printMatrix(matrixB);
        System.out.println("Result Matrix:");
        printMatrix(resultMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
