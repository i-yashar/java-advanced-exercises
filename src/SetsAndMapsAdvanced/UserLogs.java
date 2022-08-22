package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> userInfo = new TreeMap<>();

        while(true){
            String input = reader.readLine();

            if(input.equals("end")) break;

            String IPAddress = input.substring(input.indexOf("=") + 1, input.indexOf(" "));
            String username = input.substring(input.lastIndexOf("=") + 1);

            userInfo.putIfAbsent(username, new LinkedHashMap<>());
            userInfo.get(username).putIfAbsent(IPAddress, 0);
            userInfo.get(username).put(IPAddress, userInfo.get(username).get(IPAddress) + 1);
        }

        for (String name : userInfo.keySet()) {
            System.out.println(name + ": ");
            String[] IPs = userInfo.get(name).keySet().toArray(String[]::new);
            for (int i = 0; i < userInfo.get(name).size() - 1; i++) {
                System.out.printf("%s => %d, ", IPs[i], userInfo.get(name).get(IPs[i]));
            }
            System.out.printf("%s => %d.%n", IPs[IPs.length - 1], userInfo.get(name).get(IPs[IPs.length - 1]));
        }

//        System.out.println();
    }
}
