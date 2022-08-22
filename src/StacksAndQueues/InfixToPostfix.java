package StacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        String[] tokens = reader.readLine().split(" ");

        for (String token : tokens) {
            if(isNotOperator(token))
                outputQueue.offer(token);
            else if(isOperator(token)){
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(") && (precedence(operatorStack.peek(), token) >= 0)){
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.push(token);
            } else if(token.equals("(")){
                operatorStack.push(token);
            } else if(token.equals(")")){
                while(!operatorStack.isEmpty() && !operatorStack.peek().equals("("))
                    outputQueue.offer(operatorStack.pop());
                operatorStack.pop();
            }
        }
        while(!operatorStack.isEmpty())
            outputQueue.offer(operatorStack.pop());

        while(!outputQueue.isEmpty())
            System.out.print(outputQueue.poll() + " ");
    }

    private static boolean isNotOperator(String token) {
        return !token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/") && !token.equals("(") && !token.equals(")");
    }

    private static int precedence(String op1, String op2) {
        int op1Precedence = 0, op2Precedence = 0;

        if(op1.equals("*") || op1.equals("/"))
            op1Precedence = 1;
        if(op2.equals("*") || op2.equals("/"))
            op2Precedence = 1;

        return op1Precedence - op2Precedence;
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
