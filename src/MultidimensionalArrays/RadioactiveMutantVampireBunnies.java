package MultidimensionalArrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        char[][] map = readMatrix(scanner, rows, cols);

        String moves = scanner.nextLine();

        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            int[] coordinates = getPlayerCoordinates(map);
            int r = coordinates[0];
            int c = coordinates[1];

            int result = movePlayer(map, coordinates, move);

            if(result == 1){
                multiplyBunnies(map);
                printMatrix(map);
                System.out.println("won: " + r + " " + c);
                break;
            } else if(result == -1){
                if(move == 'R') c++;
                else if(move == 'U') r--;
                else if(move == 'L') c--;
                else if(move == 'D') r++;
                multiplyBunnies(map);
                printMatrix(map);
                System.out.println("dead: " + r + " " + c);
                break;
            }

            coordinates = getPlayerCoordinates(map);

            boolean isDead = multiplyBunnies(map);

            if(isDead){
                printMatrix(map);
                System.out.println("dead: " + coordinates[0] + " " + coordinates[1]);
                break;
            }
        }

//        System.out.println();
    }

    private static boolean multiplyBunnies(char[][] map){
        boolean isPlayerHit = false;

        char[][] mapCopy = new char[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            mapCopy[i] = Arrays.copyOf(map[i], map[i].length);
        }

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map[r].length; c++) {
                if(mapCopy[r][c] == 'B'){
                    if(isInBounds(map, r, c + 1)){
                        if(mapCopy[r][c + 1] == 'P') isPlayerHit = true;
                        map[r][c + 1] = 'B';
                    }
                    if(isInBounds(map, r - 1, c)){
                        if(mapCopy[r - 1][c] == 'P') isPlayerHit = true;
                        map[r - 1][c] = 'B';
                    }
                    if(isInBounds(map, r, c - 1)){
                        if(mapCopy[r][c - 1] == 'P') isPlayerHit = true;
                        map[r][c - 1] = 'B';
                    }
                    if(isInBounds(map, r + 1, c)){
                        if(mapCopy[r + 1][c] == 'P') isPlayerHit = true;
                        map[r + 1][c] = 'B';
                    }
                }
            }
        }

        return isPlayerHit;
    }

    private static int movePlayer(char[][] map, int[] coordinates, char move) {
        int row = coordinates[0];
        int col = coordinates[1];

        switch (move){
            case 'R':
                int r = row;
                int c = col + 1;
                if(!isInBounds(map, r, c)){
                    map[row][col] = '.';
                    return 1;
                }
                else if(map[r][c] == '.'){
                    map[r][c] = 'P';
                    map[row][col] = '.';
                    return 0;
                } else
                    return -1;
            case 'U':
                r = row - 1;
                c = col;
                if(!isInBounds(map, r, c)){
                    map[row][col] = '.';
                    return 1;
                }
                else if(map[r][c] == '.'){
                    map[r][c] = 'P';
                    map[row][col] = '.';
                    return 0;
                } else
                    return -1;
            case 'L':
                r = row;
                c = col - 1;
                if(!isInBounds(map, r, c)){
                    map[row][col] = '.';
                    return 1;
                }
                else if(map[r][c] == '.'){
                    map[r][c] = 'P';
                    map[row][col] = '.';
                    return 0;
                } else
                    return -1;
            case 'D':
                r = row + 1;
                c = col;
                if(!isInBounds(map, r, c)){
                    map[row][col] = '.';
                    return 1;
                }
                else if(map[r][c] == '.'){
                    map[r][c] = 'P';
                    map[row][col] = '.';
                    return 0;
                } else
                    return -1;
        }

        return 5;
    }

    private static boolean isInBounds(char[][] map, int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
    }

    private static int[] getPlayerCoordinates(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] == 'P')
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char i : arr) {
                System.out.print(i);
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

    private static int[] readArray(Scanner scanner, String pattern) {
        return Arrays.stream(scanner.nextLine().split(pattern)).mapToInt(Integer::parseInt).toArray();
    }
}
