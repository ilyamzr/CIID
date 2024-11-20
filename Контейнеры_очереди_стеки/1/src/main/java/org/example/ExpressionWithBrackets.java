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
                operators.push(ch);
            } else if (ch == ')' && !operators.isEmpty()) {
                String right = output.pop();
                String left = output.pop();
                char operator = operators.pop();
                String newExpr = "(" + left + operator + right + ")";
                output.push(newExpr);
            }
            else if (ch == ')') {
                String newExpr = "(" + output.pop() + ")";
                output.push(newExpr);
            }
        }
        while (!operators.isEmpty()) {
            String right = output.pop();
            String left = output.pop();
            char operator = operators.pop();
            String newExpr = left + operator + right;
            output.push(newExpr);
        }

        return output.isEmpty() ? "" : output.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}