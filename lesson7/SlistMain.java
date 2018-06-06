import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class SlistMain {
    
    public static void main(String[] args){
        if(args.length==0){
            // 【1】 ファイル名入力なし
            Slist fruitsList = new Slist();
            fruitsList.insert ( "Apple" ); // 一回ずつ入力
            fruitsList.insert ( "Banana" );
            fruitsList.insert ( "Orange" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            fruitsList.insert ( "Banana" ); // データを重複させる。
            fruitsList.insert ( "Banana" );
            fruitsList.insert ( "Apple" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            fruitsList.remove ( "Banana" ); // remove のチェック
            fruitsList.remove ( "Orange" );
            fruitsList.sort ();
            fruitsList.printNodes(0);
            for(int i=0;i<3;i++) { // 過剰に remove する
                fruitsList.remove ( "Banana" );
                fruitsList.remove ( "Orange" );
                fruitsList.remove ( "Apple" );
            }
            fruitsList.sort ();
            fruitsList.printNodes(0);
        }else{
            // 【2】 「java SlistMain alice.txt」と実行すると
            // alice.txtファイル内に出てくる単語を読み取り
            // リストに挿入し、ソートしてプリント
            // 文字の読み込み方法は、以前の課題のコードを参考sにしてください
            
        }
    }

}
