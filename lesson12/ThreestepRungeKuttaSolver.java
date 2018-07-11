class ThreestepRungeKuttaSolver extends OrdinaryDifferentialSolver {
    private double k1; //3次のRunge-Kutta法で用いる k1
    private double k2; //同じく k2
    private double k3; //同じく k3

    //3次のRunge-Kutta法を解くメソッド solve()
    public void solve() {
        int i = 0;
        while (x[i] + h <= n) {
            k1 = h * y[i];
            k2 = h * (y[i] + k1 / 2.0);
            k3 = h * (y[i] - k1 + 2.0 * k2);
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + (k1 + 4.0 * k2 + k3) / 6.0;
            i++;
            System.out.println(String.format("x%d=%f, y%d=%f", i, x[i], i, y[i]));
        }
        System.out.println(String.format("Solution : y[%f] = %f", x[i], y[i]));
    }
}