package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String line = reader.readLine();

        while(line != null){
            long count = 0;

            for (char c : line.toCharArray()) {
                count += c;
            }
            System.out.println(count);
            line = reader.readLine();
        }
    }
}
