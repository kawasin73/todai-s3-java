public class InsertionSort {
    private int comparisonNum = 0; // # of comparison
    private int exchangeNum = 0; // # of exchange

    public int getComparisonNum() {
        return comparisonNum;
    }

    public int getExchangeNum() {
        return exchangeNum;
    }

    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            comparisonNum++;
            if (data[i-1] > tmp) {
                int j = i;
                while (true) {
                    exchangeNum++;
                    data[j] = data[j-1];
                    j--;

                    comparisonNum++;
                    if (j <= 0 || data[j-1] <= tmp) {
                        break;
                    }
                }
                data[j] = tmp;
            }
        }
        // ********** ここから編集してください **********

        // (1) 挿入ソートにより配列dataを昇順にするプログラムを書く
        // (2) その際，比較回数と交換回数を正しい位置でカウントしてcomparisonNum, exchangeNumに格納する

        // ********** ここまで編集してください **********
        return data;
    }
}
