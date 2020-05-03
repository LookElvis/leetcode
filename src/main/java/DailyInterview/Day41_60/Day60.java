package DailyInterview.Day41_60;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * Created by Elvis on 2020/5/3.
 */
public class Day60 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1] > 0 ? nums[i - 1] : 0;
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
