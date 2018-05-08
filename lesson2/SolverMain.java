import java.io.*;
import java.util.*;

public class SolverMain {

	public static void main(String[] args){

		System.out.println(fun(1.2398));

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int couter = 0;
			System.out.print("Question > ");
			System.out.flush();
			int num = Integer.parseInt(br.readLine());

			System.out.print("x0 > ");
			System.out.flush();
			double x0 = Double.parseDouble(br.readLine());
			double x1 = 0;


			Solver solver = null;
			if(num == 1){
				solver = new Question1();
			}else if (num == 2){
				solver = new Question2();
				System.out.print("x1 > ");
				System.out.flush();
				x1 = Double.parseDouble(br.readLine());
			}else if(num == 3){
				solver = new Question3();
			}else if(num == 4){
				solver = new Question4();
				System.out.print("x1 > ");
				System.out.flush();
				x1 = Double.parseDouble(br.readLine());
			}else if(num == 5){
				solver = new Question5();
			}
			double x = solver.solve(x0,x1);
			System.out.println("root = "+x);
		} catch (IOException e){
			System.out.println("Error: " + e);
		}
	}

	public static double fun(double x) {
		return Math.exp(-1 * Math.pow(x, 2)) - Math.log10(x);
	}

}
