package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner, " ");
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(j == 0){
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        while(true){
            String[] tokens = scanner.nextLine().split(" ");

            if(tokens[0].equals("stop")) break;

            int entranceRow = Integer.parseInt(tokens[0]);
            int r = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            if(isFull(matrix, r)){
                System.out.println("Row " + r + " full");
                continue;
            }

            int distance = Math.abs(entranceRow - r) + 1;

            int stepsToFreeSpot = distanceToSpot(matrix, r, c);

                distance += stepsToFreeSpot;
                System.out.println(distance);
        }
    }

    private static boolean isFull(int[][] matrix, int r) {
        for (int i = 0; i < matrix[r].length; i++) {
            if(matrix[r][i] == 0)
                return false;
        }

        return true;
    }

    private static int distanceToSpot(int[][] matrix, int r, int c) {
        int distance = -1;
        int i = 0;

        if(matrix[r][c] == 0){
            matrix[r][c] = 1;
            return c;
        }

        while(i < matrix[r].length && matrix[r][i] != 0){
            i++;
        }

        if(i < matrix[r].length){
            matrix[r][i] = 1;
            distance = i;
        }

        return distance;
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        return matrix;
    }

    private static boolean isValid(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean isValid(char[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private static boolean areEqual(int[][] matrixOne, int[][] matrixTwo) {
        if(matrixOne.length != matrixTwo.length)
            return false;
        if(matrixOne[0].length != matrixTwo[0].length)
            return false;

        for (int r = 0; r < matrixOne.length; r++) {
            for (int c = 0; c < matrixOne[r].length; c++) {
                if(matrixOne[r][c] != matrixTwo[r][c])
                    return false;
            }
        }

        return true;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(Scanner scanner, String pattern) {
        int[] dimensions = readArray(scanner, pattern);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner, pattern);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
