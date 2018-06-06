import java.io.*;
import java.util.*;


public class Slist {
    private Snode head;
    
    public int countNode(){
        Snode node = head;
        int counter =0;
        // すべてのノードの個数を返す.

    }
    
    public Snode findNode(String x){
        Snode node = head;
        Snode returnNode = null;
        // データ x を持つデータがあれば、そのノードを返す．
        // なければ、null を返す.

    }

    public Snode insert(String x){
        Snode node = head;
        Snode foundNode = null;
        // データxをもつノードが存在しなければ，リストの先頭に挿入する.
        // もし，存在すれば，そのノードの count を１増やす．該当するノードを返す．

    }

    public void remove(String x){
        Snode node = head;
        Snode foundNode = null;
        // データxを持つノードが存在しなければ何もしない．
        // ノードが存在すれば，そのノードのcount を１減らす．
        // もし，count が０になれば，そのノードをリストから削除する．
        // （注：先頭のノードを削除する場合には， head も書き換えること）

    }

    public void printNodes(int minCount){
        System.out.println("---------------------------------");
        int counter = countNode();
        System.out.println("Total Number of Nodes ="+counter);
        // データ要素を先頭から順番に調べ、
        // getCount() の値が minCount より大きければ、プリントする.
        // [ ] はプリントするノードの通し番号，( ) は count の個数である．
        // また、先頭に、全ノード数を書く.

    }

    public void sort(){
    	//getCount()の値が大きい順にノードの並び変えを行う
        int nodeNum = countNode();
        if(nodeNum==0){
              
        }else{
            Snode[] nodes = new Snode[nodeNum];
            Snode node = head;
            int n=0;
            while(node!=null){
                nodes[n]=node;
                node = node.getNext();
                n++;
            }
            for(int i=0;i<nodeNum-1;i++){
                for(int j=i;j<nodeNum;j++){
                    if(nodes[i].getCount()<nodes[j].getCount()){
                        Snode dummyNode =nodes[i];
                        nodes[i] =nodes[j];
                        nodes[j] = dummyNode;
                    }
                }
            }
            this.head = nodes[0];
            for(int i=0;i<nodeNum;i++) {
                if(i==0) {
                    nodes[i].setPrev(null);
                }
                else{
                    nodes[i].setPrev(nodes[i-1]); 
                }
                if(i==nodeNum-1) { 
                    nodes[nodeNum-1].setNext(null); 
                }else{
                    nodes[i].setNext(nodes[i+1]); 
                }
            }    
        }
    }
    
}
