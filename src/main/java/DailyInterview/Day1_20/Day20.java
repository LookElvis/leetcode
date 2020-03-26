package DailyInterview.Day1_20;

/**
 * https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 * Created by Elvis on 2020/3/22.
 */
public class Day20 {
    public static void main(String[] args) {
        Day20 day20 = new Day20();
        int[] A = {14,4,5,14,13,14,10,17,2,12,2,14,7,13,14,13,4,16,4,10};
        System.out.println(day20.minIncrementForUnique(A));
    }

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int[] count = new int[40000 + max];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;
        }
//        Utils.printIntArrays(count);
        int taken = 0;
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                res = res - i * (count[i] - 1);
                taken += (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                res += i;
                taken--;
            }
        }
        return res;
    }
}
