package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpressionWithBrackets {
    private static final Logger logger = Logger.getLogger(ExpressionWithBrackets.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logger.info("Введите выражение: ");
        String expression = scanner.nextLine();
        if (!expression.isEmpty()) {
            logger.log(Level.INFO, String.format("Выражение с недостающими скобками: %s", addMissingBrackets(expression)));
        }
    }

    private static String addMissingBrackets(String expression) {
        Deque<String> output = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isDigit(ch)) {
                output.push(Character.toString(ch));
            } else if (isOperator(ch)) {
                while (!operators.isEmpty() && getPriority(ch) <= getPriority(operators.peek())) {
                    String right = output.pop();
                    String left = output.pop();
                    char op = operators.pop();
                    output.push("(" + left + op + right + ")");
                }
                operators.push(ch);
            }
        }

        while (!operators.isEmpty()) {
            String right = output.pop();
            String left = output.pop();
            char op = operators.pop();
            output.push("(" + left + op + right + ")");
        }

        return output.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int getPriority(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> 0;
        };
    }
}