public class Question4 implements Solver {

	public double solve(double x0, double x1) {
		double TINY = 0.0, HUGE=1.0E+10, TOL=1.0E-7;
		int max=100;  //最大反復回数
		int status=9;  //状態変数 0:正常 7:入力エラー 8:極値 9:オーバーロード
		double oldx=x0, oldx1=x1, newx=x0, fdx=0.0, fx;
		boolean flag = true;
		int iter=0;

		println(0, newx);

		for (int i = 1; i < max; i++) {
			fdx = diffFun(oldx, oldx1);
			fx = fun(oldx1);
			if (fdx == 0) {
				status = 8;
				return newx;
			}

			newx = oldx1 - (fx / fdx);

			println(i, newx);

			if (newx < TINY || newx > HUGE) {
				status = 7;
				return newx;
			}
			if (Math.abs(oldx - newx) < TOL) {
				status = 0;
				return newx;
			}
			oldx = oldx1;
			oldx1 = newx;
		}
		status = 9;
		return newx;
	}

	private void println(int i, double x) {
		System.out.print("Secant; i=");
		System.out.print(Integer.toString(i));
		System.out.print(",x=");
		System.out.println(Double.toString(x));
	}

	public double fun(double x) {
		return Math.exp(-1 * Math.pow(x, 2)) - Math.log10(x);
	}

	public double diffFun(double x0, double x1) {
		return (fun(x1) - fun(x0)) / (x1 - x0);
	}

}
