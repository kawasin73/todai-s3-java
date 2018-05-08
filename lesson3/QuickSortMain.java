import java.io.StreamTokenizer;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

class QuickSortMain {
	static final String INPUT_FILE_NAME = "data.txt";
	static final String OUTPUT_FILE_NAME = "quick_学籍番号.txt";

	//data数を数える
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
			System.out.println("text file \"" + fileName + "\" was not found");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		return count;
	}

	//dataを配列に直す
	public static int[] readInt(String fileName) {
		int count = 0;
		int[] data = new int[countLine(fileName)];
		try {
			FileReader fr = new FileReader(fileName);
			StreamTokenizer st = new StreamTokenizer(fr);
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				if (st.ttype == StreamTokenizer.TT_NUMBER) {
					data[count] = (int)st.nval;
					count++;
				}
			}
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("text file \"" + fileName + "\" was not found");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		return data;
	}

	public static void main(String[] args) {
		int[] data = readInt(INPUT_FILE_NAME);

		System.out.println("--QuickSort.before--");
			for (int i=0; i < data.length; i++) {
				System.out.println("[" + i + "]: " + data[i]);
			}
		data = QuickSort.sort(data, 0, data.length-1);

		try {
			FileWriter fw = new FileWriter(OUTPUT_FILE_NAME);
			System.out.println("--QuickSort.after--");
			fw.write("-- Quick Sort --\n");

			for (int i=0; i < data.length; i++) {
				System.out.println("[" + i + "]: " + data[i]);
				fw.write("[" + i + "]: " + data[i] + "\n");
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Error:" + e);
		}
	}
}
