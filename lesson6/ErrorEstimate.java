import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ErrorEstimate {
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input points' interval h:");
            System.out.flush();
            double h = Double.parseDouble(br.readLine());

            System.out.print("input x0(-h<=x0<=h):");
            System.out.flush();
            double x0 = Double.parseDouble(br.readLine());

            System.out.print("input x1(-h<=x0<x1<=h):");
            System.out.flush();
            double x1 = Double.parseDouble(br.readLine());

            System.out.println(String.format("The absolute value of maximum error is: %.10f", MaxErrorEstimate(h)));
            for (double x = x0; x <= x1; x += h / 10.0) {
                System.out.println(String.format("error(%.10f)=%.10f", x, ErrorEstimateCalc(h, x)));
            }
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

    static double LagrangeCalc(double[] x, double[] f, double xint) {
        // x[]: x座標   f[]: 関数値   xint: 補間点
        double fint = 0.0;
        for (int i = 0; i < x.length; i++) {
            double l = 1.0;
            for (int j = 0; j < x.length; j++) {
                if (j == i) {
                    continue;
                }
                l *= (xint - x[j]) / (x[i] - x[j]);
            }
            fint += (l * f[i]);
        }
        return fint;
    }

    static double ErrorEstimateCalc(double h, double xi) {
        double x[] = new double[3];
        double f[] = new double[3];
        x[0] = -h;
        x[1] = 0.0;
        x[2] = h;
        f[0] = Math.sin(-h);
        f[1] = Math.sin(0);
        f[2] = Math.sin(h);
        return Math.sin(xi) - LagrangeCalc(x, f, xi);
    }

    static double MaxErrorEstimate(double h) {
        double x[] = new double[3];
        x[0] = -h;
        x[1] = 0.0;
        x[2] = h;

        double b = (x[0] + x[1] + x[2]);
        double target1 = -b + Math.sqrt(b * b - 3.0 * (x[0] * x[1] + x[1] * x[2] + x[0] * x[2])) / 3.0;
        double target2 = -b - Math.sqrt(b * b - 3.0 * (x[0] * x[1] + x[1] * x[2] + x[0] * x[2])) / 3.0;

        double f1 = (target1 - x[0]) * (target1 - x[1]) * (target1 - x[2]) / 6;
        double f2 = (target2 - x[0]) * (target2 - x[1]) * (target2 - x[2]) / 6;

        if (f2 > f1) {
            f1 = f2;
        }

        return f1;
    }

}
