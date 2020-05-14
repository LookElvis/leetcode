package DailyInterview;

/**
 * https://leetcode-cn.com/problems/single-number/
 * Created by Elvis on 2020/5/11.
 */
public class Day68 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
