import java.io.*;
import java.util.*;

public class LeastSquareMethod {

    private double[] x = new double[10];
    private double[] y = new double[10]; // 入力データ
    private int n;    // 入力データ数
    private int d;    // 次数
    private double a[][];    //答え

    // double[] x, y, int n, dを初期化する
    public void set() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input the number of data:");
            System.out.flush();
            n = Integer.parseInt(br.readLine());
            System.out.print("input the degree of x:");
            System.out.flush();
            d = Integer.parseInt(br.readLine()) + 1;


            for (int i = 0; i < n; i++) {
                System.out.print("input No." + i + " x:");
                System.out.flush();
                x[i] = Double.parseDouble(br.readLine());
                System.out.print("input No." + i + " y:");
                System.out.flush();
                y[i] = Double.parseDouble(br.readLine());
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }

    }

    // double[] x, y, int n, dを使ってa[][]を求める
    public void solve() {
        double[][] A = new double[n][];

        for (int i = 0; i < n; i++) {
            A[i] = new double[d];
            for (int j = 0; j < d; j++) {
                A[i][j] = Math.pow(x[i], j);
            }
        }

        double[][] W = new double[d][];
        for (int i = 0; i<d; i++) {
            W[i] = new double[d+1];
        }

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                W[i][j] = calcw(A, i, j);
            }
        }

        for (int i = 0; i < d; i++) {
            W[i][d] = calcy(A, i);
        }

        //ここを作成
        a = PivotGauss(W);
    }

    private double calcw(double[][] A, int i, int j) {
        double sum = 0.0;
        for (int k = 0; k< A.length; k++) {
            sum += A[k][i] * A[k][j];
        }
        return sum;
    }

    private double calcy(double[][] A, int i) {
        double sum = 0.0;
        for (int k = 0; k <A.length; k++) {
            sum += A[k][i] * y[k];
        }
        return sum;
    }

    // aを出力する
    public void print() {
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k][a[0].length - 1]);
        }
    }


    /*
    ガウス消去法
    m元連立方程式の解を求める手法である
    解くにあたり係数行列と右辺ベクトルを合わせてm×(m+1)の行列求め、引数matrixとして用いる
    ガウス消去法の処理が行われ、戻り値aのm+1列目がm元連立方程式の解にあたる
    */
    private double[][] PivotGauss(double[][] matrix) {
        double TINY = 1.0E-10;
        int N = matrix.length, j = 0, status = 0;
        double pivot, multi, sum, max, aik;
        double tmp[][] = new double[N][N + 1];

        for (int k = 0; k < N - 1; k++) {
            max = 0.0;
            for (int i = k; i < N; i++) {
                aik = Math.abs(matrix[i][k]);
                if (aik > max) {
                    max = aik;
                    j = i;
                }
            }
            if (j != k) {
                for (int i = 0; i < N + 1; i++) {
                    tmp[k][i] = matrix[k][i];
                    matrix[k][i] = matrix[j][i];
                    matrix[j][i] = tmp[k][i];
                }
            }
            //前進消去

            pivot = 1.0 / matrix[k][k];
            multi = matrix[k + 1][k] * pivot;
            if (Math.abs(multi) > TINY) {
                for (int i = k + 1; i < N; i++) {
                    multi = matrix[i][k] * pivot;
                    for (j = k; j < N + 1; j++) {
                        matrix[i][j] -= multi * matrix[k][j];
                    }
                }
            } else {
                matrix[j][k] = 0.0;
            }
        }
        if (Math.abs(matrix[N - 1][N - 1]) < TINY) status = 9;


        if (status == 0) {  // 後退代入
            for (int k = N - 1; k >= 0; k--) {
                sum = matrix[k][N];
                for (j = k + 1; j < N; j++) {
                    sum -= matrix[k][j] * matrix[j][N];
                }
                matrix[k][N] = sum / matrix[k][k];
            }
        } else {
            System.out.println(">pivotGauss, Failed! the system is singular.");
        }
        return matrix;
    }
}

