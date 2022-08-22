package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Map<String, Integer> durations = new TreeMap<>();
        Map<String, Set<String>> IPs = new TreeMap<>();

        while(n-- > 0){
            String[] tokens = reader.readLine().split(" ");
            String IP = tokens[0];
            String name = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            durations.putIfAbsent(name, 0);
            IPs.putIfAbsent(name, new TreeSet<>());

            durations.put(name, durations.get(name) + duration);
            IPs.get(name).add(IP);
        }

        durations.entrySet().stream().forEach(e -> {
            System.out.printf("%s: %d [%s]%n", e.getKey(), e.getValue(), String.join(", ", IPs.get(e.getKey())));
        });

//        System.out.println();
    }
}
