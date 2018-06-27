public class TrapezoidalSolver implements ISolver {

    //積分するメソッド
    public double Solve() {
        System.out.println("Calculate by trapezoidal rule");

        //台形則の式で計算してその答えを返
        return (1 - (-1)) * (Math.exp(-1) + Math.exp(1)) / 2.0;
    }
}