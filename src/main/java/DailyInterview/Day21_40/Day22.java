package DailyInterview.Day21_40;

/**
 * 动态规划
 * https://leetcode-cn.com/problems/the-masseuse-lcci/submissions/
 * Created by Elvis on 2020/3/24.
 */
public class Day22 {
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < max.length; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
        }
        return max[max.length - 1];
    }
}
