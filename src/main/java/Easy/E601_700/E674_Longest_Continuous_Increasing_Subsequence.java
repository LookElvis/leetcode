package Easy.E601_700;

/**
 * https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * Created by Elvis on 2020/3/12.
 */
public class E674_Longest_Continuous_Increasing_Subsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }

        int max = 1;
        int tmp = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                tmp++;
            } else {
                tmp = 1;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }
}
