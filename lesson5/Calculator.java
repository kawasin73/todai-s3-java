import java.util.*;

public class Calculator {
    private boolean isOperator(String token) {
        // token が演算子 +, -, *, / のいずれかならば true を返すプログラムを以下に書きます。
        switch (token) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    private String calc(String op, String v1, String v2) {
        double n1 = Double.parseDouble(v1);
        double n2 = Double.parseDouble(v2);
        switch (op) {
            case "+":
                return Double.toString(n1 + n2);
            case "-":
                return Double.toString(n1 - n2);
            case "*":
                return Double.toString(n1 * n2);
            case "/":
                return Double.toString(n1 / n2);
            default:
                System.out.println("invalid operator");
                return "0";
        }
    }

    private boolean isNumber(String token) {
        // token が数値ならば true を返すプログラムを以下に書きます。
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getAnswer(String equation) {
        Stack stack = new Stack();
        StringTokenizer st = new StringTokenizer(equation);

        while (st.hasMoreElements()) {
            String token = st.nextToken();

            // token に数字や演算子が一つずつ順番に代入されていきます。
            // 演算子なら式を評価した結果を，数値ならその値が
            // stack の先頭に格納されるプログラムを以下に書きます.
            if (isNumber(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                String v1 = stack.pop();
                String v2 = stack.pop();
                String result = calc(token, v2, v1);
                stack.push(result);
            } else {
                System.out.println("invalid token : " + token);
            }
        }

        // stack の先頭を数字に変換して返します。
        return Double.parseDouble(stack.pop());
    }

    // 答えだけ書く人は、この関数は削除する。
    public String getEquation(String equation) {
        Stack stack = new Stack();
        StringTokenizer st = new StringTokenizer(equation);

        while (st.hasMoreElements()) {
            String token = st.nextToken();

            // token に数字や演算子が一つずつ順番に代入されていきます。
            // それらを処理して、中置記法の数式が stack の先頭に格納されるよ
            // うなプログラムを以下に書きます.
            if (isNumber(token)) {
                stack.push(token);
            } else if (isOperator(token)) {
                String v1 = stack.pop();
                String v2 = stack.pop();
                String result = String.format("(%s %s %s)", v2, token, v1);
                stack.push(result);
            } else {
                System.out.println("invalid token : " + token);
            }
        }

        return stack.pop();
    }

    // 中置記法の数式 を を逆ポーランド記法に変換する
    public String convToF(String equation) {
        StringTokenizer st = new StringTokenizer(equation);

        return conv(st);
    }

    private String conv(StringTokenizer st) {
        Stack stack = new Stack();

        while (st.hasMoreElements()) {
            String token = st.nextToken();

            if (isOperator(token)) {
                switch (token) {
                    case "+":
                    case "-":
                        stack.push(token);
                        break;
                    case "*":
                    case "/":
                        String v1 = stack.pop();
                        String v2 = st.nextToken();
                        if (v2.equals("(")) {
                            v2 = conv(st);
                        }
                        String result = String.format("%s %s %s", v1, v2, token);
                        stack.push(result);
                }
            } else if (token.equals("(")) {
                stack.push(conv(st));
            } else if (token.equals(")")) {
                break;
            } else if (isNumber(token)) {
                stack.push(token);
            } else {
                System.out.println("invalid token : " + token);
            }
        }

        // reduce phase
        String result = stack.pop();
        while (!stack.peek().equals("")) {
            String token = stack.pop();
            if (!isOperator(token)) {
                System.out.println("invalid token in reduce phase" + result + " : " + token);
                break;
            }
            String v = stack.pop();
            result = String.format("%s %s %s", v, result, token);
        }
        return result;
    }
}