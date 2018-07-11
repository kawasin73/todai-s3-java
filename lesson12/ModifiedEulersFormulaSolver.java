class ModifiedEulersFormulaSolver extends OrdinaryDifferentialSolver {
    private double k1; //修正Euler法で用いるk1

    //修正Euler法を解くメソッド solve()
    public void solve() {
        int i = 0;
        while (x[i] + h <= n) {
            k1 = h * y[i];
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + h * (y[i] + k1 / 2.0);
            i++;
            System.out.println(String.format("x%d=%f, y%d=%f", i, x[i], i, y[i]));
        }
        System.out.println(String.format("Solution : y[%f] = %f", x[i], y[i]));
    }
}
