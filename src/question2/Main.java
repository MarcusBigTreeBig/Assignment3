package question2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static char[] validOperations = {'+', '-', '*', '/'}; //The symbols that will be treated as operations

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input postfix expression, each operation and operand should be separated by a space, valid operations are: ");
        for (char c: validOperations) {
            System.out.print(c + " ");
        }
        System.out.println();
        String expression = input.nextLine();
        System.out.println(valueOfPostfixExpression(expression));
    }

    /**
     * Assumes each input is seperated by a space
     * If each input is not in the form of a numeric or one of the valid operations, it will be ignored
     *
     * @param expression
     * @return the value of the expression
     */
    public static double valueOfPostfixExpression (String expression) {
        double operand1;
        double operand2;
        double result = 0;
        int start = 0;
        Stack<Double> stack = new Stack<Double>();
        ArrayList<String> substrings = new ArrayList<String>();
        //seperate into substrings from where the spaces are located
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') {
                if (i != start) {
                    substrings.add(expression.substring(start, i));
                }
                start = i+1;
            }
        }
        substrings.add(expression.substring(start));//add the last substring
        for (String s: substrings) {
            if (isNumeric(s)) {
                stack.push(Double.parseDouble(s));
            }else if (s.length() == 1 && isValidOperation(s.charAt(0))) {
                //evaluate with the top 2 operands on the stack
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
        return stack.top();//if the input is a valid postfix expression, only the result should be left on the stack
    }

    /**
     *
     * @param c the character checked
     * @return true if the character is found in the valid operations array
     */
    public static boolean isValidOperation (char c) {
        for (int i = 0; i < validOperations.length; i++) {
            if (c == validOperations[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param s
     * @return true if s can be converted to a double
     */
    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}

/*
Input/Output:

Input postfix expression, each operation and operand should be separated by a space, valid operations are: + - * /
3 6 + 2 4 - * 7 +
-11.0

 */