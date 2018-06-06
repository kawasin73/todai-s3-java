import java.io.*;
import java.util.*;


public class Slist {
    private Snode head;

    public int countNode() {
        int counter = 0;
        // すべてのノードの個数を返す.
        for (Snode node = head; node != null; node = node.getNext()) {
            counter++;
        }
        return counter;
    }

    public Snode findNode(String x) {
        Snode returnNode = null;
        // データ x を持つデータがあれば、そのノードを返す．
        // なければ、null を返す.
        for (Snode node = head; node != null; node = node.getNext()) {
            if (x.equals(node.getData())) {
                returnNode = node;
                break;
            }
        }
        return returnNode;
    }

    public Snode insert(String x) {
        // データxをもつノードが存在しなければ，リストの先頭に挿入する.
        // もし，存在すれば，そのノードの count を１増やす．該当するノードを返す．
        if (head == null) {
            head = new Snode(x);
            return head;
        }
        Snode foundNode = findNode(x);
        if (foundNode == null) {
            foundNode = new Snode(x);
            head.setPrev(foundNode);
            foundNode.setNext(head);
            head = foundNode;
        } else {
            foundNode.increaseCount();
        }
        return foundNode;
    }

    public void remove(String x) {
        // データxを持つノードが存在しなければ何もしない．
        // ノードが存在すれば，そのノードのcount を１減らす．
        // もし，count が０になれば，そのノードをリストから削除する．
        // （注：先頭のノードを削除する場合には， head も書き換えること）
        Snode foundNode = findNode(x);
        if (foundNode == null) {
            return;
        }
        if (foundNode.getCount() > 1) {
            foundNode.decreaseCount();
            return;
        }
        Snode prev = foundNode.getPrev();
        Snode next = foundNode.getNext();
        if (prev == null) {
            head = null;
        } else {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
    }

    public void printNodes(int minCount) {
        System.out.println("---------------------------------");
        int counter = countNode();
        System.out.println("Total Number of Nodes =" + counter);
        // データ要素を先頭から順番に調べ、
        // getCount() の値が minCount より大きければ、プリントする.
        // [ ] はプリントするノードの通し番号，( ) は count の個数である．
        // また、先頭に、全ノード数を書く.
        Snode node = head;
        for (int i = 0; i < counter; i++) {
            if (node.getCount() >= minCount) {
                System.out.println(String.format("Node[%d]:(Count=%d) = %s", i, node.getCount(), node.getData()));
            }
            node = node.getNext();
        }
    }

    public void sort() {
        //getCount()の値が大きい順にノードの並び変えを行う
        int nodeNum = countNode();
        if (nodeNum < 2) {
            return;
        }
        Snode[] nodes = new Snode[nodeNum];
        Snode node = head;
        int n = 0;
        while (node != null) {
            nodes[n] = node;
            node = node.getNext();
            n++;
        }
        for (int i = 0; i < nodeNum - 1; i++) {
            for (int j = i; j < nodeNum; j++) {
                if (nodes[i].getCount() < nodes[j].getCount()) {
                    Snode dummyNode = nodes[i];
                    nodes[i] = nodes[j];
                    nodes[j] = dummyNode;
                }
            }
        }
        this.head = nodes[0];
        for (int i = 0; i < nodeNum; i++) {
            if (i == 0) {
                nodes[i].setPrev(null);
            } else {
                nodes[i].setPrev(nodes[i - 1]);
            }
            if (i == nodeNum - 1) {
                nodes[nodeNum - 1].setNext(null);
            } else {
                nodes[i].setNext(nodes[i + 1]);
            }
        }
    }

}
