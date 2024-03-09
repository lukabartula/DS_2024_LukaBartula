package week2;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();

        String[] elements = expression.split(" ");

        for (String element : elements) {
            if (element.equals("(")) {
                continue;
            } else if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/") || element.equals("^") || element.equals("√") || element.equals("%")) {
                operators.push(element);
            } else if (element.equals(")") && operators.peek().equals("√")) {
                operators.pop();
                Double value = values.pop();
                values.push(Math.sqrt(value));
            } else if (element.equals(")") && !operators.peek().equals("√")) {
                String operator = operators.pop();
                Double value2 = values.pop();
                Double value1 = values.pop();

                switch (operator) {
                    case "+" :
                        values.push(value1 + value2);
                        break;
                    case "-" :
                        values.push(value1 - value2);
                        break;
                    case "*" :
                        values.push(value1 * value2);
                        break;
                    case "/" :
                        values.push(value1 / value2);
                        break;
                    case "^" :
                        values.push(Math.pow(value1, value2));
                        break;
                    case "%" :
                        values.push(value1 % value2);
                        break;
                }
            } else {
                double number = Double.parseDouble(element);
                values.push(number);
            }
        }
        return values.pop();
    }
}
