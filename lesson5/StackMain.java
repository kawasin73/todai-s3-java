import java.io.*;
import java.util.*;

public class StackMain {
    public static void main(String[] args) {
        String command, input; // コマンドと入力
        int initSize = 4; // スタックの配列初期サイズ
        Stack stack = new Stack(initSize); // スタック作成
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) { // quitが入力されるまでループ
            command = "";
            input = "";
            System.out.print("command > ");
            System.out.flush();
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());

                // この部分では，キーボードから入力された文字列を
                // String 型の変数 command (コマンド名) と input (入力データ)
                // に代入する．たとえば，"push test" とキーボードから打つと，
                // command: "push", input: "test" が代入される．
                if (st.hasMoreElements()) {
                    command = st.nextToken();
                }
                if (st.hasMoreElements()) {
                    input = st.nextToken();
                }

                System.out.println(command + " " + input);
                System.out.flush();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }

            if (command.equals("quit")) {
                // ここにquitと入力されたときの処理を書いてください
                break;
            } else if (command.equals("push")) {
                // ここにpushと入力されたときの処理を書いてください
                stack.push(input);
            } else if (command.equals("pop")) {
                // ここにpopと入力されたときの処理を書いてください
                String out = stack.pop();
                if (out.equals("")) {
                    System.out.println("=== no value is stacked ===");
                } else {
                    System.out.println(out);
                }
            } else if (command.equals("peek")) {
                // ここにpeekと入力されたときの処理を書いてください
                String out = stack.peek();
                if (out.equals("")) {
                    System.out.println("=== no value is stacked ===");
                } else {
                    System.out.println(out);
                }
            } else {
                System.out.println("Command is not found: " + command);
            }
        }
    }
}