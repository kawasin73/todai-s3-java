import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class SlistMain {

    public static void main(String[] args) {
        if (args.length == 0) {
            // 【1】 ファイル名入力なし
            Slist fruitsList = new Slist();
            fruitsList.insert("Apple"); // 一回ずつ入力
            fruitsList.insert("Banana");
            fruitsList.insert("Orange");
            fruitsList.sort();
            fruitsList.printNodes(0);
            fruitsList.insert("Banana"); // データを重複させる。
            fruitsList.insert("Banana");
            fruitsList.insert("Apple");
            fruitsList.sort();
            fruitsList.printNodes(0);
            fruitsList.remove("Banana"); // remove のチェック
            fruitsList.remove("Orange");
            fruitsList.sort();
            fruitsList.printNodes(0);
            for (int i = 0; i < 3; i++) { // 過剰に remove する
                fruitsList.remove("Banana");
                fruitsList.remove("Orange");
                fruitsList.remove("Apple");
            }
            fruitsList.sort();
            fruitsList.printNodes(0);
        } else {
            String file = args[0];
            Slist list = new Slist();
            // 【2】 「java SlistMain alice.txt」と実行すると
            // alice.txtファイル内に出てくる単語を読み取り
            // リストに挿入し、ソートしてプリント
            // 文字の読み込み方法は、以前の課題のコードを参考sにしてください
            try {
                FileReader fr = new FileReader(file);
                StreamTokenizer st = new StreamTokenizer(fr);
                while (st.nextToken() != StreamTokenizer.TT_EOF) {
                    if (st.ttype == StreamTokenizer.TT_WORD) {
                        list.insert(st.sval);
                    }
                }
                fr.close();
            } catch (FileNotFoundException e) {
                System.out.println("text file \"" + file + "\" was not found");
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }

            list.sort();
            list.printNodes(5);
        }
    }

}
