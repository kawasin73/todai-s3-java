import java.io.*;

public class PivottedGaussElim {
    int status;

    public static void main(String[] args) {
        PivottedGaussElim g = new PivottedGaussElim();
        g.solvePivotGauss();
    }

    void solvePivotGauss() {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("変数の数？ = ");
            System.out.flush();
            int n = Integer.parseInt(br.readLine());
            double a[][] = new double[n][n + 1];
            for (int i = 0; i < n; i++) {
                System.out.print("Row" + (i + 1) + ">");
                System.out.flush();
                String stri = br.readLine();
                String[] str = stri.split(" ");
                for (int j = 0; j < n + 1; j++) {
                    a[i][j] = Double.parseDouble(str[j]);
                }
            }

            int N = a.length;
            PivotGauss(a);
            if (status == 0) {
                for (int i = 0; i < N; i++) System.out.println("i=" + i + ",  " + a[i][N]);
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }


    }

    /**
     * ピボット選択Gauss消去法による連立方程式の解析メソッド
     * status変数(エラーコード):  0:正常, 9:異常
     * 入力 : a[][]=係数行列および右辺ベクトル
     * 出力 : a[][N]
     */
    void PivotGauss(double[][] a) {
        double TINY = 1.0E-10;
        int N = a.length;
        double pivot, multi, sum, d;

        // move forward
        for (int k = 0; k < N - 1; k++) {
            // change pivot
//            j = i;
//            max =  Math.abs(a[j][i]);
//            for (int k = 0; k <N-1;k++) {
//                if (Math.abs(a[k][i]) > max) {
//                    j = k;
//                    max = Math.abs(a[j][i]);
//                }
//            }
//            tmp = a[i];

            pivot = a[k][k];
            if (Math.abs(pivot) < TINY) {
                // TODO: change pivot
                status = 9;
                return;
            }
            d = 1.0 / pivot;

            for (int i = k + 1; i < N; i++) {
                multi = a[i][k] * d;
                for (int j = k + 1; j < N + 1; j++) {
                    a[i][j] = a[i][j] - multi * a[k][j];
                }
            }
        }

        // move backward
        a[N - 1][N] = a[N - 1][N] / a[N - 1][N - 1];
        for (int i = N - 2; i >= 0; i--) {
            sum = a[i][N];
            for (int j = N - 1; j > i; j--) {
                sum -= a[j][N] * a[i][j];
            }
            a[i][N] = sum / a[i][i];
        }
    }
}
