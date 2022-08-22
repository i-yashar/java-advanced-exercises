package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<String> lines = new ArrayList<>();
        String rotation = scanner.nextLine();
        int degrees = Integer.parseInt(rotation.substring(rotation.indexOf("(") + 1, rotation.indexOf(")")));
        int position = (degrees / 90) % 4;

        while(true){
            String input = scanner.nextLine();

            if(input.equals("END")) break;

            lines.add(input);
        }

        int maxLength = 0;
        for (String line : lines) {
            if(line.length() > maxLength)
                maxLength = line.length();
        }

        char[][] matrix = new char[lines.size()][maxLength];

        int count = 0;
        for (String line : lines) {
            for (int j = 0; j < maxLength; j++) {
                if(j < line.length())
                    matrix[count][j] = line.charAt(j);
                else
                    matrix[count][j] = ' ';
            }
            count++;
        }

        if(position == 0){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if(position == 1){
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        } else if(position == 2){
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[i].length - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else{
            for (int i = matrix[0].length - 1; i >= 0; i--) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[j][i]);
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
