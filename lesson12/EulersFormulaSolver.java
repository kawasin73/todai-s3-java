class EulersFormulaSolver extends OrdinaryDifferentialSolver {
    //Euler法の公式を用いて解くメソッド solve()
    public void solve() {
        int i = 0;
        while (x[i] + h <= n) {
            x[i + 1] = x[i] + h;
            y[i + 1] = y[i] + h * y[i];
            i++;
            System.out.println(String.format("x%d=%f, y%d=%f", i, x[i], i, y[i]));
        }
        System.out.println(String.format("Solution : y[%f] = %f", x[i], y[i]));
    }
}