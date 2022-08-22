package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] plants = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] days = new int[n];

        ArrayDeque<Integer> prevPlants = new ArrayDeque<>();

        prevPlants.push(0);

        for (int i = 0; i < plants.length; i++) {
            int day = 0;

            while(!prevPlants.isEmpty() && plants[prevPlants.peek()] >= plants[i]){
                day = Math.max(day, days[prevPlants.pop()]);
            }

            if(!prevPlants.isEmpty()){
                days[i] = day + 1;
            }

            prevPlants.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}