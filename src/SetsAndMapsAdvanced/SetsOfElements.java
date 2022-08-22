package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);
        Set<Integer> N = new LinkedHashSet<>();
        Set<Integer> M = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            N.add(Integer.parseInt(reader.readLine()));
        }
        for (int i = 0; i < m; i++) {
            M.add(Integer.parseInt(reader.readLine()));
        }

        for (Integer num : N) {
            if(M.contains(num))
                System.out.print(num + " ");
        }
    }
}