package Interview;

import PublicClass.Utils;

/**
 * Created by Elvis on 2020/3/3.
 */
public class Day1 {
    public static void main(String[] args) {
        int[] A = {1,2,3,0,0,0};
        int m = 3;
        int[] B = {2,5,6};
        int n = 3;
        merge(A, m, B, n);
        Utils.printIntArrays(A);
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int pA = m - 1;
        int pB = n - 1;
        int len = A.length - 1;
        while (pA >= 0 && pB >= 0) {
            if (A[pA] <= B[pB]) {
                A[len--] = B[pB--];
            } else {
                A[len--] = A[pA--];
            }
        }
        while (pB >= 0) {
            A[len--] = B[pB--];
        }
    }
}
