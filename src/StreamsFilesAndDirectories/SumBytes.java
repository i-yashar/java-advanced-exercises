package StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        String line = reader.readLine();
        long count = 0;

        while(line != null){

            for (char c : line.toCharArray()) {
                count += c;
            }
            line = reader.readLine();
        }

        System.out.println(count);
    }
}
