import java.io.*;
import java.util.*;

abstract class OrdinaryDifferentialSolver implements ISolver {
    double[] x = new double[10]; //xi用配列
    double[] y = new double[10]; //yi用配列
    double h; //刻み幅 h
    double n; //xの範囲用変数 n

    //値をセットするメソッドset()
    public void set() {
        try {
            BufferedReader sr = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("step_size = ");
            System.out.flush();
            h = Double.parseDouble(sr.readLine());
            System.out.print("x <= ");
            System.out.flush();
            n = Double.parseDouble(sr.readLine());

            double max = n / h;
            Double d = new Double(max);
            int maxSize = d.intValue() + 10;
            x = new double[maxSize];
            y = new double[maxSize];

            System.out.print("y(0) = ");
            System.out.flush();
            y[0] = Double.parseDouble(sr.readLine());

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }
}