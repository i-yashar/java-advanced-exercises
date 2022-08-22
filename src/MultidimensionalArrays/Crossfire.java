package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = i * cols + j + 1;
                matrix[i][j] = value;
            }
        }

        while(true){
            String input = scanner.nextLine();

            if(input.equals("Nuke it from orbit"))
                break;

            int row = Integer.parseInt(input.split(" ")[0]);
            int col = Integer.parseInt(input.split(" ")[1]);
            int radius = Integer.parseInt(input.split(" ")[2]);

            if(isValid(matrix, row, col)){
                int r = row, c = col + 1, strength = radius;
                while(isValid(matrix, r, c) && strength > 0){
                    matrix[r][c++] = 0;
                    strength--;
                }

                r = row - 1; c = col; strength = radius;
                while(isValid(matrix, r, c) && strength > 0){
                    matrix[r--][c] = 0;
                    strength--;
                }

                r = row + 1; c = col; strength = radius;
                while(isValid(matrix, r, c) && strength > 0){
                    matrix[r++][c] = 0;
                    strength--;
                }

                matrix[row][col] = 0;

                r = row; c = col - 1; strength = radius;
                while(isValid(matrix, r, c) && strength > 0){
                    matrix[r][c--] = 0;
                    strength--;
                }
            }

            rearrangeMatrix(matrix, rows, cols);
        }

        for (int[] arr : matrix) {
            for (int i : arr) {
                if(i != 0)
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void rearrangeMatrix(int[][] matrix, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols - 1; c++) {
                if(matrix[r][c] == 0){
                    for (int i = c; i < cols - 1; i++) {
                        matrix[r][i] = matrix[r][i + 1];
                    }
                    matrix[r][cols - 1] = 0;
                    if(hasNumberAhead(matrix[r], c + 1))
                        c--;
                }
            }
        }
    }

    private static boolean hasNumberAhead(int[] arr, int index) {
        for (int i = index; i < arr.length; i++) {
            if(arr[index] != 0)
                return true;
        }
        return false;
    }

    private static boolean isValid(List<List<Integer>> matrix, int r, int c) {
        return r >= 0 && r < matrix.size() && c >= 0 && c < matrix.get(r).size();
    }

    private static boolean isValid(String[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean isValid(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
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