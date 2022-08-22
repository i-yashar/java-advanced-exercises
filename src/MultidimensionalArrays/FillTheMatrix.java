package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[n][n];

        int counter = 0;

        if(pattern.equals("A")){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = ++counter;
                }
            }
        }
        if(pattern.equals("B")){
            for (int i = 0; i < n; i++) {
                if(i % 2 == 0){
                    for (int j = 0; j < n; j++) {
                        matrix[j][i] = ++counter;
                    }
                } else{
                    for (int j = n - 1; j >= 0; j--) {
                        matrix[j][i] = ++counter;
                    }
                }
            }
        }

        printMatrix(matrix);
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

