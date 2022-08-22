package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Labs {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = readArray(scanner, " ");
        }
        
        int[] tokens = readArray(scanner, " ");
        int wrongValue = matrix[tokens[0]][tokens[1]];
        List<int[]> fixInfo = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if(matrix[r][c] == wrongValue){
                    fixInfo.add(new int[]{r, c, calculateRightValue(matrix, r, c, wrongValue)});
                }
            }
        }

        for (int[] info : fixInfo) {
            matrix[info[0]][info[1]] = info[2];
        }

        printMatrix(matrix);
    }

    private static int calculateRightValue(int[][] matrix, int r, int c, int wrongValue) {
        int sum = 0;

        if(isValidIndex(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue)
            sum += matrix[r - 1][c];
        if(isValidIndex(matrix, r, c - 1) && matrix[r][c - 1] != wrongValue)
            sum += matrix[r][c - 1];
        if(isValidIndex(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue)
            sum += matrix[r + 1][c];
        if(isValidIndex(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue)
            sum += matrix[r][c + 1];

        return sum;
    }

    private static boolean isValidIndex(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length;
    }


    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scanner, int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        return matrix;
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
