import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ErrorEstimate {
	public static void main(String args[]){
		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("input points' interval h:");
			System.out.flush();
			double h=Double.parseDouble(br.readLine());

			System.out.print("input x0(-h<=x0<=h):");
			System.out.flush();
			double x0=Double.parseDouble(br.readLine());
			
			System.out.print("input x1(-h<=x0<x1<=h):");
			System.out.flush();
			double x1=Double.parseDouble(br.readLine());
			

			/*
		
			ここを編集してください

			*/


		}catch (IOException e){
			System.out.println("Error:"+e);
		}
	}
		
	static double ErrorEstimateCalc(double h,double x){
		/*
		
		ここを編集してください

		*/
	}

	static double MaxErrorEstimate(double h){
		/*
		
		ここを編集してください

		*/
	}

}
