package Generics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");

        String firstName = input[0];
        String secondName = input[1];
        String address = input[2];
        String town = input[3];

        StringBuilder nameFull = new StringBuilder();
        nameFull.append(firstName).append(" ").append(secondName);

        Threeuple<String, String, String> firstTuple = new Threeuple<>(nameFull.toString(), address, town);

        input = reader.readLine().split(" ");

        String name = input[0];
        int litres = Integer.parseInt(input[1]);
        boolean isDrunk =  input[2].equals("drunk");

        Threeuple<String, Integer, Boolean> secondTuple = new Threeuple<>(name, litres, isDrunk);


        input = reader.readLine().split("\\s+");
        name = input[0];
        double balance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> thirdTuple = new Threeuple<>(name, balance, bankName);

        StringBuilder firstOutput = new StringBuilder();
        firstOutput.append(firstTuple.getElementOne()).append(" -> ").append(firstTuple.getElementTwo()).append(" -> ").append(firstTuple.getElementThree());
        StringBuilder secondOutput = new StringBuilder();
        secondOutput.append(secondTuple.getElementOne()).append(" -> ").append(secondTuple.getElementTwo()).append(" -> ").append(secondTuple.getElementThree());
        StringBuilder thirdOutput = new StringBuilder();
        thirdOutput.append(thirdTuple.getElementOne()).append(" -> ").append(thirdTuple.getElementTwo()).append(" -> ").append(thirdTuple.getElementThree());

        System.out.println(firstOutput.toString());
        System.out.println(secondOutput);
        System.out.println(thirdOutput);
    }
}
