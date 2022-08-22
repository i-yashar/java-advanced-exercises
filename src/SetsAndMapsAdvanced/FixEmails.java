package SetsAndMapsAdvanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> emails = new LinkedHashMap<>();

        while(true){
            String name = reader.readLine();

            if(name.equals("stop")) break;

            String email = reader.readLine();

            String domain = email.substring(email.lastIndexOf(".") + 1);
            if(!domain.equalsIgnoreCase("us") && !domain.equalsIgnoreCase("uk") && !domain.equalsIgnoreCase("com")){
                emails.put(name, email);
            }
        }

        for (String n : emails.keySet()) {
            System.out.println(n + " -> " + emails.get(n));
        }
    }
}
