import java.io.*;
import java.util.*;

public class SolverMain{

    public static void main(String args[]){
        //問題番号用の変数q
        int q=0;

        //問題番号を読み込む Question_number = ?
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Question_number = ");
            q = Integer.parseInt(br.readLine());
        }
        catch(IOException e){
            System.out.println("Error:"+e);
        }
   
        ISolver od;
        //Question_number = 1 : Euler法
        if(q == 1){
            od = new EulersFormulaSolver();
        }
        //Question_number = 2 : 修正Euler法
        else if(q == 2){
            od = new ModifiedEulersFormulaSolver();
        }
        //Question_numbet = 3 : 2次のRunge-Kutta法
        else if(q == 3){
            od = new TwostepRungeKuttaSolver();
        }
        //Question_number = 4 : 3次のRunge-Kutta法
        else if(q == 4){
            od = new ThreestepRungeKuttaSolver();
        }
        //問題番号以外の数字が入力されたとき
        else{
            System.out.println("Question "+q+ " don't exist.");
            return;
        }

        od.set();
        od.solve();
    }
}
