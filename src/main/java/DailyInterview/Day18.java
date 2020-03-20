package DailyInterview;

import java.util.Arrays;

/**
 * Created by Elvis on 2020/3/20.
 */
public class Day18 {
    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }
        qArray(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public static void qArray(int[] array, int l, int r, int k) {
        int p = partition(array, l, r);
        if (p == k) {
            return;
        } else if (p < k) {
            qArray(array, p + 1, r, k);
        } else {
            qArray(array, l, p - 1, k);
        }
    }

    public static int partition(int[] array, int l, int r) {
        int pivlot = array[l + (int) Math.random() * (r - l + 1)];
//        int pivlot = array[r];
        int i = l - 1;
        int j = r + 1;
        while (l < j) {
            if (array[l] < pivlot) {
                swap(array, ++i, l++);
            } else if (array[l] > pivlot) {
                swap(array, --j, l);
            } else {
                l++;
            }
        }
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
}
