package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner, " ");

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char firstLetter = (char)('a' + r);
                char secondLetter = (char)('a' + r + c);
                char lastLetter = firstLetter;
                matrix[r][c] = (firstLetter + "") + (secondLetter + "") + (lastLetter + "");
            }
        }

        for (String[] arr : matrix) {
            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
