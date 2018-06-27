import java.io.*;
import java.util.*;

public class IntegralMain {

	//積分方法を指定するための定数
	private static final int SOL_TRA = 1;
	private static final int SOL_GAU = 2;

	public static void main(String[] args){
		try{
			//積分方法を指定する部分
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Trapezoidal rule > Put 1");
			System.out.println("Gaussian quadrature > Put 2");
			System.out.print("How to solve? >");
			System.out.flush();
			int sol = Integer.parseInt(br.readLine());

			//積分方法毎に異なるインスタンスを生成
			ISolver solver = null;
			if (sol == SOL_TRA){
				solver = new TrapezoidalSolver();
			} else if (sol == SOL_GAU){
				solver = new GaussianSolver();
			} //未定義の整数が入力されたらエラーを返す 
			else throw new IndexOutOfBoundsException();

			//インスタンスのSolveメソッド（積分するメソッド）を呼び出して結果を表示
			double ans = solver.Solve();
			System.out.println("Integration = " + ans);

		//例外処理の記述
		} catch (IndexOutOfBoundsException e){
			System.out.println("The solution is not defined.");
		} catch (NumberFormatException e){
			System.out.println("Illegal input was detected.");
			System.out.println("Please input the correct number.");
		} catch (IOException e){
			System.out.println("Error: " + e);
		}
	}
}

//インターフェイスISolverの定義
interface ISolver{
	//積分するメソッド
	double Solve();
	//被積分関数
	default double fun(double x){
		double fx = Math.exp(x);
		return fx;
	}
	//積分範囲の定数
	double DOWN = -1.0;
	double UP = 1.0;
}
