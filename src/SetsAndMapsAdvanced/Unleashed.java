package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Unleashed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String regex = "(?<name>(\\w+ )+)@(?<venue>([A-Za-z]+ )+)(?<price>\\d+ )(?<count>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        Map<String, Map<String, Integer>> venueInfo = new LinkedHashMap<>();

        while(true){
            String input = reader.readLine();

            if(input.equals("End")) break;

            matcher = pattern.matcher(input);

            String singer = "";
            String venue = "";
            int price = 0;
            int count = 0;

            if(matcher.find()){
                singer = matcher.group("name").trim();
                venue = matcher.group("venue").trim();
                price = Integer.parseInt(matcher.group("price").trim());
                count = Integer.parseInt(matcher.group("count").trim());
            }

            venueInfo.putIfAbsent(venue, new LinkedHashMap<>());
            venueInfo.get(venue).putIfAbsent(singer, 0);
            venueInfo.get(venue).put(singer, venueInfo.get(venue).get(singer) + price * count);
        }

        venueInfo.entrySet().stream().filter(e -> !e.getKey().equals("")).forEach(e -> {
            System.out.println(e.getKey());
            e.getValue().entrySet().stream().sorted((l, r) -> r.getValue().compareTo(l.getValue()))
                    .forEach(s -> System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue()));
        });

//        System.out.println();
    }
}
