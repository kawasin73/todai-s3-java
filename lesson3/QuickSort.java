class QuickSort {
    public static int[] sort(int[] data, int left, int right) {
        if (left == right) {
            return data;
        }
        if (left > right) {
            System.out.println(String.format("invalid left: %d, right: %d", left, right));
            return data;
        }
        int middle = (left + right) / 2;
        int pivot = data[middle];
        int i = left, j = right;

        while (true) {
            for (; data[i] < pivot; i++) {
            }
            for (; data[j] > pivot; j--) {
            }
            if (i > j) {
                break;
            }
            // swap
//            System.out.println(String.format("swap left: %d, right: %d", i, j));
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
            i++;
            j--;
        }
//        System.out.println(String.format("swap fin left: %d, right: %d", i, j));
        if (j > left) {
            sort(data, left, j);
        }

        if (i < right) {
            sort(data, i, right);
        }

        return data;
    }
}
