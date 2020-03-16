package Medium;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * Created by Elvis on 2020/3/16.
 */
public class M011_Container_With_Most_Water {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int tmp;
        for (int i = 1; i < height.length; i++) {
            tmp = height[i];
            for (int j = 0; j < i; j++) {
                if (height[j] <= height[i]) {
                    max = Math.max(max, height[j] * (i - j));
                } else {
                    max = Math.max(max, height[i] * (i - j));
                    break;
                }
            }
        }
        return max;
    }
}
