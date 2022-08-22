package BasicAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Labs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int begin, int end) {
        int i = begin, j = end;
        int mid = arr[(i + j) / 2];

        do{
            while(arr[i] < mid) i++;
            while(arr[j] > mid) j--;

            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while(i <= j);

        if(begin < j)
            quickSort(arr, begin, j);
        if(i < end)
            quickSort(arr, i, end);
    }
}
