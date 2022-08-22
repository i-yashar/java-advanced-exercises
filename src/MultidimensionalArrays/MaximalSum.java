package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner, " ");

        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0, maxCol = 0;

        for (int r = 0; r < rows - 2; r++) {
            for (int c = 0; c < cols - 2; c++) {
                int sum = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2]
                        + matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if(sum > maxSum){
                    maxSum = sum;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.println(matrix[maxRow][maxCol] + " " + matrix[maxRow][maxCol + 1] + " " + matrix[maxRow][maxCol + 2]);
        System.out.println(matrix[maxRow + 1][maxCol] + " " + matrix[maxRow + 1][maxCol + 1] + " " + matrix[maxRow + 1][maxCol + 2]);
        System.out.println(matrix[maxRow + 2][maxCol] + " " + matrix[maxRow + 2][maxCol + 1] + " " + matrix[maxRow + 2][maxCol + 2]);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char i : arr) {
                System.out.print(i + " ");
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
