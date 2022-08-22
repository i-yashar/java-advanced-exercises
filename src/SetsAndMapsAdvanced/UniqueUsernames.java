package SetsAndMapsAdvanced;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.math.BigDecimal;
        import java.text.DecimalFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Set<String> usernames = new LinkedHashSet<>();

        while(n-- > 0){
            usernames.add(reader.readLine());
        }

        for (String username : usernames) {
            System.out.println(username);
        }
    }
}

