package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PopulationCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> populationInfo = new LinkedHashMap<>();
        Map<String, Long> totalPopulation = new LinkedHashMap<>();

        while(true){
            String[] tokens = reader.readLine().split("\\|");

            if(tokens[0].equals("report")) break;

            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);

            populationInfo.putIfAbsent(country, new LinkedHashMap<>());
            populationInfo.get(country).put(city, population);
            totalPopulation.putIfAbsent(country, 0L);
            totalPopulation.put(country, totalPopulation.get(country) + population);
        }

        totalPopulation.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(e -> {
                    System.out.printf("%s (total population: %d)%n", e.getKey(), e.getValue());
                    String name = e.getKey();
                    populationInfo.get(name).entrySet().stream().sorted((f1, f2) -> f2.getValue().compareTo(f1.getValue()))
                            .forEach(f -> System.out.printf("=>%s: %d%n", f.getKey(), f.getValue()));
                });
//        System.out.println();
    }
}
