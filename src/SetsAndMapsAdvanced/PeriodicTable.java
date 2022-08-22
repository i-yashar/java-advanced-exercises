package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<String> elements = new TreeSet<>();

        while(n-- > 0){
            String[] tokens = reader.readLine().split(" ");
            elements.addAll(Arrays.asList(tokens));
        }

        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}