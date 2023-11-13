package question2;

import java.util.ArrayList;

public class Main {
    public static char[] validOperations = {'+', '-', '*', '/'};

    public static void main (String[] args) {
        String expression = "3 6 + 2 4 - * 7 +";
        int expectedValue = -11;
        System.out.println(valueOfPostfixExpression(expression));
    }

    public static double valueOfPostfixExpression (String expression) {
        double operand1;
        double operand2;
        double result = 0;
        int start = 0;
        Stack<Double> stack = new Stack<Double>();
        ArrayList<String> substrings = new ArrayList<String>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                if (i != start) {
                    substrings.add(expression.substring(start, i));
                }
                start = i+1;
            }
        }
        substrings.add(expression.substring(start));
        for (String s: substrings) {
            if (isNumeric(s)) {
                stack.push(Double.parseDouble(s));
            }else if (s.length() == 1 && isValidOperation(s.charAt(0))) {
                operand2 = stack.top();
                stack.pop();
                operand1 = stack.top();
                stack.pop();
                switch (s.charAt(0)) {
                    case '+':
                        result = operand1+operand2;
                        break;
                    case '-':
                        result = operand1-operand2;
                        break;
                    case '*':
                        result = operand1*operand2;
                        break;
                    case '/':
                        result = operand1/operand2;
                        break;
                }
                stack.push(Double.valueOf(result));
            }
        }
        return stack.top();
    }

    public static boolean isValidOperation (char c) {
        for (int i = 0; i < validOperations.length; i++) {
            if (c == validOperations[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String s) {
        if (s == null) {
            return false;
        }
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
