import java.io.*;

public class InsertionSortMain {

    static final String INPUT_FILE_NAME = "data.txt";
    static final String OUTPUT_FILE_NAME = "xx-xxxxxx.txt";

    public static int countLine(String fileName) {
        int count = 0;
        try {
            FileReader fr = new FileReader(fileName);
            StreamTokenizer st = new StreamTokenizer(fr);
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    count++;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("text file \"" + fileName + "\" was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return count;
    }

    public static int[] readInt(String fileName) {
        int count = 0;
        int[] data = new int[countLine(fileName)];
        try {
            FileReader fr = new FileReader(fileName);
            StreamTokenizer st = new StreamTokenizer(fr);
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    data[count] = (int) st.nval;
                    count++;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("text file \"" + fileName + "\" was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return data;
    }

    public static void main(String[] args) {
        int[] data = readInt(INPUT_FILE_NAME);
        InsertionSort is = new InsertionSort();
        data = is.sort(data);

        // ********** ここから編集してください **********

        // (1) 出力例に従って「学籍番号.txt」へと結果を出力する

        // ********** ここまで編集してください **********


        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE_NAME);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("-- Insertion Sort --");
            for (int i = 0; i < data.length; i++) {
                pw.println("[" + i + "]: " + data[i]);
            }
            pw.println("# of comparison: " + is.getComparisonNum());
            pw.println("# of exchange: " + is.getExchangeNum());

            fw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
}
