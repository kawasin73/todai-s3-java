import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Lagrange{
	static double LagrangeCalc(double[] x, double[] f, double xint){
		// x[]: x座標   f[]: 関数値   xint: 補間点
		/*
		
		ここを編集してください

		*/
	}

	public static void main(String agrs[]){
		try{
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			System.out.print("input the number of known points:");
			System.out.flush();
			int n=Integer.parseInt(br.readLine());
            int flag=0;
            while(n<2&&flag==0){
                System.out.print("elligal input, please input again(input -1 to exit): ");
                System.out.flush();
                n=Integer.parseInt(br.readLine());
                if(n==-1){
                    flag=1;
                }
            }
            
            if(flag==0){
			double x[]=new double[n];
			double f[]=new double[n];
			
			for(int i=0; i<n; i++){
				System.out.print("input No."+i+" x:");
				System.out.flush();
				x[i]=Double.parseDouble(br.readLine());
				System.out.print("input No."+i+" f(x):");
				System.out.flush();
				f[i]=Double.parseDouble(br.readLine());
			}

			/*
		
			ここを編集してください

			*/

            }
		}catch (IOException e){
			System.out.println("Error:"+e);
		}
	}
}
