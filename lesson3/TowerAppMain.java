import java.io.*;

class TowerAppMain{
    public static String getString() throws IOException {
        try{
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            return s;
        }catch(IOException e){
            System.out.println ( "Error: " + e );
            return null;
        }
    }
    
    public static int getInt() throws IOException {
        try{
            String s = getString();
            int num = Integer.parseInt(s);
            return num;
        }catch(IOException e){
            System.out.println ( "Error: " + e );
            return 0;
        }
    }
    
    public static void main(String[] args) throws IOException{
        int inputNum;
        System.out.print("Number of Plates: ");
        System.out.flush();
        inputNum = getInt();
        TowerApp.doTowers(inputNum,'a', 'b', 'c');
    }
}
