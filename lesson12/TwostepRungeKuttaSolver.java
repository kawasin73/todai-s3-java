class TwostepRungeKuttaSolver extends OrdinaryDifferentialSolver {
    private double k1; //2次のRunge-Kutta法で用いるk1
    private double k2; //2次のRunge-Kutta法で用いるk2

    //2次のRunge-Kutta法を解くメソッド solve()
    public void solve() {
        int i = 0;
        while (x[i] + h <= n) {
            k1 = h * y[i];
            k2 = h * (y[i] + k1);
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + (k1 + k2) / 2.0;
            i++;
            System.out.println(String.format("x%d=%f, y%d=%f", i, x[i], i, y[i]));
        }
        System.out.println(String.format("Solution : y[%f] = %f", x[i], y[i]));
    }
}

