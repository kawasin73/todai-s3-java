import java.io.*;
import java.util.*;

public class BinaryTreeMain {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command, input; // コマンド，入力
		double value = 0; // 数値
		BinaryTree tree = new BinaryTree(); // 二分探索木の作成

		while (true) {
			command = "";
			input = "";

			boolean hasValue = false; // 数値が入力されたときtrueになる

			System.out.print("command > ");
			System.out.flush();

			try {
				StringTokenizer st = new StringTokenizer(br.readLine());

				// 最初のトークンはコマンド
				if (st.hasMoreElements()) {
					command = st.nextToken();
				}
				// 次のトークンがあれば数値
				if (st.hasMoreElements()) {
					input = st.nextToken();
					try {
						value = Double.parseDouble(input);
						hasValue = true;
					} catch (NumberFormatException e) {
						System.out.println("Illegal number was entered: " + input);
						continue;
					}
				}

				System.out.println(command + " " + input);
				System.out.flush();
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}

			if (command.equals("quit")) {
				break;
			} else if (command.equals("min")) {

				// 最小値をプリントする処理を書く
				Node node = tree.getMinNode();
				if (node == null) {
					System.out.println("No value stored");
				} else {
					System.out.println(String.format("Min = %f", node.getValue()));
				}
			} else if (command.equals("max")) {

				// 最大値をプリントする処理を書く
				Node node = tree.getMaxNode();
				if (node == null) {
					System.out.println("No value stored");
				} else {
					System.out.println(String.format("Max = %f", node.getValue()));
				}
			} else if (command.equals("find")) {

				// 指定した値があるか調べる処理を書く
				if (hasValue) {
					Node node = tree.findNode(value);
					if (node == null) {
						System.out.println(String.format("%f was not found.", value));
					} else {
						System.out.println(String.format("%f was found.", node.getValue()));
					}
				} else {
					System.out.println("No value error");
				}
			} else if (command.equals("insert")) {

				// 値を挿入する処理を書く
				if (hasValue) {
					tree.insertNode(value);
				} else {
					System.out.println("No value error");
				}

			} else if (command.equals("remove")) {

				// 値を削除する処理を書く
				if (hasValue) {
					Node node = tree.findNode(value);
					if (node == null) {
						System.out.println(String.format("%f was not found.", value));
					} else {
						tree.removeNode(node);
					}
				} else {
					System.out.println("No value error");
				}
			} else if (command.equals("print")) {
				tree.printTree();
			} else {
				System.out.println("Command is not found: " + command);
			}
		}
	}
}