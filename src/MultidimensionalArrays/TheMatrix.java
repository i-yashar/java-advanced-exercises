package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner, " ");
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = readMatrix(scanner, rows, cols);

        char fillChar = scanner.nextLine().charAt(0);
        int[] tokens = readArray(scanner, " ");
        int startRow = tokens[0];
        int startCol = tokens[1];
        char startChar = matrix[startRow][startCol];

        fillTheMatrix(matrix, startRow, startCol, startChar, fillChar);

        printMatrix(matrix);

//        System.out.println();
    }

    private static void fillTheMatrix(char[][] matrix, int startRow, int startCol, char startChar, char fillChar) {
        if(!isValid(matrix, startRow, startCol) || matrix[startRow][startCol] != startChar){
            return;
        } else {
            matrix[startRow][startCol] = fillChar;
            fillTheMatrix(matrix, startRow, startCol + 1, startChar, fillChar);
            fillTheMatrix(matrix, startRow - 1, startCol, startChar, fillChar);
            fillTheMatrix(matrix, startRow, startCol - 1, startChar, fillChar);
            fillTheMatrix(matrix, startRow + 1, startCol, startChar, fillChar);
        }
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
