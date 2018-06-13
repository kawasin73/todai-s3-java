import java.io.*;

public class LeastSquareMethodSin {
    private double[] x = new double[100];
    private double[] y = new double[100]; // 入力データ
    private double c0, c1, c2; // 入力係数
    private int n;  // 入力データ数
    private double a[][];   //答え
    private double TINY = 0.001;

    // double[] x, y, int n, dを初期化する
    public void set() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input c0:");
            System.out.flush();
            c0 = Double.parseDouble(br.readLine());

            System.out.print("input c1:");
            System.out.flush();
            c1 = Double.parseDouble(br.readLine());

            System.out.print("input c2:");
            System.out.flush();
            c2 = Double.parseDouble(br.readLine());

            System.out.print("input the number of data:");
            System.out.flush();
            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                System.out.print("input No." + (i + 1) + " x:");
                System.out.flush();
                x[i] = Double.parseDouble(br.readLine());
                System.out.print("input No." + (i + 1) + " y:");
                System.out.flush();
                y[i] = Double.parseDouble(br.readLine());
            }

        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }


    public void solve() {
        a = new double[3][4];

        for (int l = 1; true; l++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = calca(i, j);
                }
                a[i][3] = calcy(i);
            }

            a = PivotGauss(a);

            c0 += a[0][3];
            c1 += a[1][3];
            c2 += a[2][3];

            for (int i = 0; i < 3; i++) {
                System.out.println(String.format("delc%d:%f", i, a[i][3]));
            }
            System.out.println(String.format("c0:%f", c0));
            System.out.println(String.format("c1:%f", c1));
            System.out.println(String.format("c2:%f", c2));
            System.out.println(String.format("%d回目の処理です", l));

            if (Math.abs(a[0][3]) < TINY && Math.abs(a[1][3]) < TINY && Math.abs(a[2][3]) < TINY) {
                break;
            }
        }
    }

    private double calca(int i, int j) {
        double sum = 0.0;
        for (int k = 0; k < n; k++) {
            sum += diffF(i, x[k]) * diffF(j, x[k]);
        }
        return sum;
    }

    private double calcy(int i) {
        double sum = 0.0;
        for (int k = 0; k < n; k++) {
            sum += diffF(i, x[k]) * (y[k] - c0 * Math.sin(c1 * x[k] + c2));
        }
        return sum;
    }

    private double diffF(int c, double x) {
        switch (c) {
            case 0:
                return Math.sin(c1 * x + c2);
            case 1:
                return c0 * x * Math.cos(c1 * x + c2);
            case 2:
                return c0 * Math.cos(c1 * x + c2);
            default:
                System.out.println("invalid c : " + String.valueOf(c));
                return 0;
        }
    }

    // aを出力する

    public void print() {
        for (int k = 0; k < a.length; k++) {
            System.out.println(a[k][a[0].length - 1]);
        }

        for (int k = 0; k < a.length; k++) {
            System.out.println("delc" + k + ":" + a[k][a[0].length - 1]);
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
        //if(Math.abs(matrix[N-1][N-1])<TINY) status = 9;


        if (status == 0) {  // 後退代入
            for (int k = N - 1; k >= 0; k--) {
                sum = matrix[k][N];
                for (j = k + 1; j < N; j++) {
                    sum -= matrix[k][j] * matrix[j][N];
                }
                matrix[k][N] = sum / matrix[k][k];

            }
        } else {
            System.out.println(status);
            System.out.println(">pivotGauss, Failed! the system is singular.");
        }
        return matrix;
    }
}
