package DailyInterview.Day1_20;

/**
 * https://leetcode-cn.com/problems/majority-element/submissions/
 * Created by Elvis on 2020/3/13.
 */
public class Day11 {
    public int majorityElement(int[] nums) {
        int most = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == most) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    most = nums[i];
                    count = 1;
                }
            }
        }
        return most;
    }
}
