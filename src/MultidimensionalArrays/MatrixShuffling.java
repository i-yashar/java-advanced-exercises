package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner, " ");

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        while(true){
            String input = scanner.nextLine();
            if(input.equals("END")) break;

            String[] tokens = input.split(" ");

            if(!tokens[0].equals("swap") || tokens.length != 5){
                System.out.println("Invalid input!");
                continue;
            }

            int r1 = Integer.parseInt(tokens[1]);
            int c1 = Integer.parseInt(tokens[2]);
            int r2 = Integer.parseInt(tokens[3]);
            int c2 = Integer.parseInt(tokens[4]);

            if(!isValid(matrix, r1, c1) || !isValid(matrix, r2, c2)){
                System.out.println("Invalid input!");
                continue;
            }

            String temp = matrix[r1][c1];
            matrix[r1][c1] = matrix[r2][c2];
            matrix[r2][c2] = temp;

            for (String[] arr : matrix) {
                for (String s : arr) {
                    System.out.print(s + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean isValid(String[][] matrix, int r, int c) {
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