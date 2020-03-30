package DailyInterview;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 圆圈中最后剩下的数字
 * Created by Elvis on 2020/3/30.
 */
public class Day28 {
    public int lastRemaining(int n, int m) {
        // 圆圈中最后剩下数字的位置一定为0，然后开始逆推删除数字之前的位置
        // 根据画图可得，当前位置res + m然后对当前数组长度i取模即为删除数字之前的位置
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
