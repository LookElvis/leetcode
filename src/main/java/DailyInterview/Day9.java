package DailyInterview;

/**
 * https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/submissions/
 * Created by Elvis on 2020/3/11.
 */
public class Day9 {
    public static void main(String[] args) {

    }

    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        int pre = 0;
        int[] add = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            add[i] = pre + A[i];
            pre = add[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        sum = sum / 3;

        for (int i = 0; i < A.length; i++) {
            if (add[i] == sum) {
                for (int j = i + 1; j < A.length - 1; j++) {
                    if (add[j] == sum * 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
