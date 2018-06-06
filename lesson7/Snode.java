import java.io.*;
import java.util.*;

public class Snode {
    private String data;//ノードのデータ要素
    private int count;//このデータが入力された回数
    private Snode prev = null;//前のノード
    private Snode next = null;//次のノード
    
    public Snode(String x){
        // コンストラクタ
        // Snodeインスタンスを作成したときに自動で呼び出されます
        data  = x;
        count = 1;
    }
    public Snode getPrev(){
        return prev;
    }
    public Snode getNext(){
        // ここに記述します
        return next;
    }
    public void setPrev(Snode prev){
        // this.prevは7行目で定義したSnodeクラスのインスタンスが保持する変数
        // prevはsetPrevを呼ぶ際に渡される引数
        this.prev = prev;
    }
    public void setNext(Snode next){
        // ここに記述します
        this.next = next;
    }
    public String getData(){
        // ここに記述します
        return data;
    }
    public int getCount(){
        // ここに記述します
        return count;
    }
    public void increaseCount(){
        // ここに記述します
        count++;
    }
    public void decreaseCount(){
        // ここに記述します
        count--;
    }

}
