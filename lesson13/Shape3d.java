import java.io.*;
import java.util.*;

public class Shape3d {

    public List<Vertex> vertexList;
    public List<Face> faceList;

    public Shape3d(String fileName) {
        //コンストラクタ
        //ファイルを読み込んでvertexListとfaceListに格納する
        //FileReader, StreamTokenizerを用いる
        //以前演習でやった例を参照すること
        vertexList = new ArrayList<>();
        faceList = new LinkedList<>();

        try {
            FileReader fr = new FileReader(fileName);
            StreamTokenizer st = new StreamTokenizer(fr);

            while (st.nextToken() == StreamTokenizer.TT_WORD) {
                if (st.sval.equals("v")) {
                    Vertex v = parseV(st);
                    if (v == null) {
                        System.out.println("invalid vertex");
                        break;
                    }
                    vertexList.add(v);
                } else if (st.sval.equals("f")) {
                    Face f = parseF(st);
                    if (f == null) {
                        System.out.println("invalid face");
                        break;
                    }
                    faceList.add(f);
                } else {
                    System.out.println("invalid token : " + st.sval);
                    break;
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("text file \"" + fileName + "\" was not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private Vertex parseV(StreamTokenizer st) throws IOException {
        double[] v = new double[3];
        for (int i = 0; i < 3; i++) {
            if (st.nextToken() != StreamTokenizer.TT_NUMBER) {
                return null;
            }
            v[i] = st.nval;
        }
        return new Vertex(v[0], v[1], v[2]);
    }

    private Face parseF(StreamTokenizer st) throws IOException {
        if (st.nextToken() != StreamTokenizer.TT_NUMBER) {
            return null;
        }
        int num = (int) st.nval;
        Vertex[] v = new Vertex[num];
        for (int i = 0; i < num; i++) {
            if (st.nextToken() != StreamTokenizer.TT_NUMBER) {
                return null;
            }
            v[i] = vertexList.get((int) st.nval);
        }
        return new Face(v);
    }
}
