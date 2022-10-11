public class InsertionSort {
    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int k = i;

            while (k > 0 && arr[k - 1] > cur) {
                arr[k] = arr[k - 1];
                k--;
            }

            arr[k] = cur;
        }
    }
}
