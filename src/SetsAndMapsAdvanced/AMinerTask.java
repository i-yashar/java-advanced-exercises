package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> resources = new LinkedHashMap<>();

        while(true){
            String resource = reader.readLine();

            if(resource.equals("stop")) break;

            int quantity = Integer.parseInt(reader.readLine());

            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);
        }

        resources.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
