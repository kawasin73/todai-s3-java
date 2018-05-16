import java.io.*;
import java.util.*;

public class QueueMain {
    public static void main(String[] args) {
        String command, input;
        int initSize = 4;
        Queue queue = new Queue(initSize);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            command = "";
            input = "";
            System.out.print("command > ");
            System.out.flush();
            try {
                StringTokenizer st = new StringTokenizer(br.readLine());

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
            } else if (command.equals("insert")) {

                // ここにinsertと入力されたときの処理を書いてください
                queue.insert(input);
            } else if (command.equals("remove")) {

                // ここにremoveと入力されたときの処理を書いてください
                String data = queue.remove();
                if (data.equals("")) {
                    System.out.println("=== no value is queued ===");
                } else {
                    System.out.println(data);
                }
            } else if (command.equals("peek")) {

                // ここにpeekと入力されたときの処理を書いてください
                String data = queue.peek();
                if (data.equals("")) {
                    System.out.println("=== no value is queued ===");
                } else {
                    System.out.println(data);
                }
            } else {
                System.out.println("Command is not found: " + command);
            }
        }
    }
}