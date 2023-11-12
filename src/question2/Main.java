package question2;

public class Main {
    public static char[] validOperations = {'+', '-', '*', '/'};

    public static void main (String[] args) {
        String expression = "36+24-*7+";
        int expectedValue = -29;
    }

    public static int valueOfPostfixExpression (String expression) {
        int value = 0;
        int operand1;
        int operand2;
        int result;
        char[] arr = expression.toCharArray();
        Stack stack = new Stack();
        for (char c: arr) {
            if (isValidOperation(c)) {
                operand2 = stack.top();
                stack.pop();
                operand1 = stack.top();
                stack.pop();
                switch (c) {
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
                stack.push(result);
            }else{
                stack.push(c);
            }
        }
        return value;
    }

    public static boolean isValidOperation (char c) {
        for (int i = 0; i < validOperations.length; i++) {
            if (c == validOperations[i]) {
                return true;
            }
        }
        return false;
    }
}
