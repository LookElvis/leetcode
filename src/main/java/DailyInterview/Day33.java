package DailyInterview;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * Created by Elvis on 2020/4/4.
 */
public class Day33 {
    public static void main(String[] args) {

    }
    
    public int trap(int[] height) {
        int left, right;
        int cnt = 0;

        for (int i = 1; i < height.length; i++) {
            left = 0;
            right = 0;
            //找当前点左侧最高的
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            //找当前点右侧最高的
            for (int j = i; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            cnt += (Math.min(left, right) - height[i]);
        }
        return cnt;
    }
}
