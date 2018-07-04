import java.util.*;

public class NQueen {
    private enum Status {
        FREE,
        NOT_FREE
    }

    private final int N;    // クイーンの数
    private int[] pos;        // 各行の置かれたクイーンの位置
    private Status[] col;    // クイーンが垂直方向に利いているかを示す配列
    private Status[] down;    // クイーンが右斜め下向きに利いているかを示す配列
    private Status[] up;    // クイーンが右斜め上向きに利いているかを示す配列
    private int count;        // 解の数

    // Nクイーン問題を解くためのオブジェクトを生成する
    public NQueen(int numberOfQueen) {
        // 配列を割り当てる
        // クイーンの位置と利き筋を初期化する
        this.N = numberOfQueen;
        this.pos = new int[numberOfQueen];
        this.col = new Status[numberOfQueen];
        this.down = new Status[2 * numberOfQueen - 1];
        this.up = new Status[2 * numberOfQueen - 1];
        this.count = 0;
        this.reset();
    }

    public boolean tryQueen(int a) {
        // 行a以降のすべての行にクイーンを置く
        // 左から右に向かって順番にクイーンが置けるかどうかを調べる
        // 行aのb列目に置けるかどうかを,利き筋の情報を元に調べる
        // 置くことができたら．場所を記録して，利き筋をセットする．
        // クイーンが置けたらtrue,置けなかったらfalseを返す
        // 行a+1以降のすべての行に置けたら成功.
        // N個のクイーンをすべて置くことができれば成功．
        for (int b = 0; b < N; b++) {
            if (col[b] == Status.NOT_FREE ||
                    down[a - b + N - 1] == Status.NOT_FREE ||
                    up[a + b] == Status.NOT_FREE) {
                continue;
            }
            pos[a] = b;
            col[b] = Status.NOT_FREE;
            down[a - b + N - 1] = Status.NOT_FREE;
            up[a + b] = Status.NOT_FREE;
            if (a >= N - 1) {
                return true;
            }
            if (tryQueen(a + 1)) {
                return true;
            }
            pos[a] = -1;
            col[b] = Status.FREE;
            down[a - b + N - 1] = Status.FREE;
            up[a + b] = Status.FREE;
        }
        return false;
    }

    // クイーンの位置を出力する
    public void print() {
        // 表示形式に沿って出力してください
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (pos[i] == j) {
                    System.out.print("Q");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private void reset() {
        Arrays.fill(pos, -1);
        Arrays.fill(col, Status.FREE);
        Arrays.fill(down, Status.FREE);
        Arrays.fill(up, Status.FREE);
    }

    public void tryQueenAll(int a) {
        // ここに処理を書きます

        for (int b = 0; b < N; b++) {
            if (col[b] == Status.NOT_FREE ||
                    down[a - b + N - 1] == Status.NOT_FREE ||
                    up[a + b] == Status.NOT_FREE) {
                continue;
            }
            pos[a] = b;
            col[b] = Status.NOT_FREE;
            down[a - b + N - 1] = Status.NOT_FREE;
            up[a + b] = Status.NOT_FREE;
            if (a >= N - 1) {
                print();
                System.out.println("=========================================");
                count++;
            } else {
                tryQueenAll(a + 1);
            }
            pos[a] = -1;
            col[b] = Status.FREE;
            down[a - b + N - 1] = Status.FREE;
            up[a + b] = Status.FREE;
        }
        if (a == 0) {
            System.out.println(String.format("Total: %d", count));
        }
    }

}
