package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> robots = readRobotData(reader.readLine());

        int[] robotTimes = new int[robots.size()];

        String[] timeTokens = reader.readLine().split(":");
        int hours = Integer.parseInt(timeTokens[0]);
        int minutes = Integer.parseInt(timeTokens[1]);
        int seconds = Integer.parseInt(timeTokens[2]);
        long currentTimeInSeconds = (long)hours * 3600 + (long)minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();

        while(true){
            String input = reader.readLine();
            if(input.equals("End")) break;

            products.offer(input);
        }

        while(!products.isEmpty()){
            String nextProduct = products.poll();

            currentTimeInSeconds++;

            decreaseTimes(robotTimes);

            boolean isAssigned = assignJob(robots, robotTimes, nextProduct, currentTimeInSeconds);

            if(!isAssigned)
                products.offer(nextProduct);
        }

        System.out.println();
    }

    private static void decreaseTimes(int[] robotTimes) {
        for (int i = 0; i < robotTimes.length; i++) {
            if(robotTimes[i] > 0)
                robotTimes[i]--;
        }
    }

    private static boolean assignJob(Map<String, Integer> robots, int[] robotTime, String nextProduct, long currentTimeInSeconds) {
        for (int i = 0; i < robotTime.length; i++) {
            if(robotTime[i] == 0){
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if(count == i){
                        robotTime[i] = entry.getValue();
                        printRobotJob(entry.getKey(), nextProduct, currentTimeInSeconds);

                        return true;
                    }
                    count++;
                }
            }
        }

        return false;
    }

    private static void printRobotJob(String robotName, String product, long currentTimeInSeconds) {
        int hours = (int)(currentTimeInSeconds / 3600) % 24;
        int minutes = (int)(currentTimeInSeconds / 60) % 60;
        int seconds = (int)currentTimeInSeconds % 60;

        System.out.printf("%s - %s [%02d:%02d:%02d]%n", robotName, product, hours, minutes, seconds);
    }

    private static Map<String, Integer> readRobotData(String line) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        Arrays.stream(line.split(";")).forEach(r -> {
            String name = r.substring(0, r.indexOf("-"));
            Integer time = Integer.parseInt(r.substring(r.indexOf("-") + 1, r.length()));
            robots.put(name, time);
        });

        return robots;
    }
}
