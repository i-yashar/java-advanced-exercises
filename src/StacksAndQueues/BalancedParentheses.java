package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> brackets = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            
            switch (ch){
                case '(':
                    addBracket(brackets, '(');
                    break;
                case '{':
                    addBracket(brackets, '{');
                    break;
                case '[':
                    addBracket(brackets, '[');
                    break;
                case ')':
                    isBalanced = checkBracket(brackets, '(');
                    break;
                case '}':
                    isBalanced = checkBracket(brackets, '{');
                    break;
                case ']':
                    isBalanced = checkBracket(brackets, '[');
                    break;
            }
            if(!isBalanced) break;
        }

        if(isBalanced && brackets.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean checkBracket(ArrayDeque<Character> brackets, char br) {
        if(brackets.isEmpty())
            return false;

        if(brackets.peek() == br){
            brackets.pop();
            return true;
        }
        return false;
    }

    private static void addBracket(ArrayDeque<Character> brackets, char bracket) {
        brackets.push(bracket);
    }
}
