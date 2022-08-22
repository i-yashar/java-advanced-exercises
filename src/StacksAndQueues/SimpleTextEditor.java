package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        ArrayDeque<String> textStates = new ArrayDeque<>();

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            if(tokens[0].equals("1")){
                textStates.push(text.toString());
                text.append(tokens[1]);
            } else if(tokens[0].equals("2")) {
                textStates.push(text.toString());
                for (int j = 0; j < Integer.parseInt(tokens[1]); j++) {
                    text.deleteCharAt(text.length() - 1);
                }
            } else if(tokens[0].equals("3")){
                System.out.println(text.charAt(Integer.parseInt(tokens[1]) - 1));
            } else if(tokens[0].equals("4")){
                text = new StringBuilder(textStates.pop());
            }
        }
    }
}
