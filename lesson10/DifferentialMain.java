import java.io.*;

public class DifferentialMain {
    
    public static void main(String[] args) {

        //点の読み出し方と微分係数の計算メソッドは分離
        //点の読み出しと計算方法を更新し易くするため
    	DifferentialSolver solver = new DifferentialSolver();
        double points[][] = solver.readPoints();
        double diff = solver.getDiff(points);

        //表示するコード
        System.out.println("Differential coefficient = " + diff);
        System.out.println("Error = "+ solver.getError(points, diff));
        System.out.println("Minimam Error = " + solver.getMinError(points));
        System.out.println("Maximam Error = " + solver.getMaxError(points));
    }
}
