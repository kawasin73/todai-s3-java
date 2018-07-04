import java.util.*;

public class NQueen {
	private enum Status {
		FREE,
		NOT_FREE
	}

	private final int N;	// クイーンの数
	private int[] pos;		// 各行の置かれたクイーンの位置
	private Status[] col;	// クイーンが垂直方向に利いているかを示す配列
	private Status[] down;	// クイーンが右斜め下向きに利いているかを示す配列
	private Status[] up;	// クイーンが右斜め上向きに利いているかを示す配列
	private int count;		// 解の数

	// Nクイーン問題を解くためのオブジェクトを生成する
	public NQueen(int numberOfQueen) {
		// 配列を割り当てる
		// クイーンの位置と利き筋を初期化する
	}

	public boolean tryQueen(int a) {
		// 行a以降のすべての行にクイーンを置く
		// 左から右に向かって順番にクイーンが置けるかどうかを調べる
		// 行aのb列目に置けるかどうかを,利き筋の情報を元に調べる
		// 置くことができたら．場所を記録して，利き筋をセットする．
		// クイーンが置けたらtrue,置けなかったらfalseを返す
		// 行a+1以降のすべての行に置けたら成功.
		// N個のクイーンをすべて置くことができれば成功．
	}

	// クイーンの位置を出力する
	public void print() {
		// 表示形式に沿って出力してください
	}

	public void tryQueenAll(int a) {
		// ここに処理を書きます
	}

}
