package DailyInterview;

import PublicClass.Utils;

/**
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 * Created by Elvis on 2020/4/1.
 */
public class Day30 {
    public static void main(String[] args) {
        Day30 day30 = new Day30();
        String s = "()(())()";
        int[] res = day30.maxDepthAfterSplit(s);
        Utils.printIntArrays(res);
    }

    // 将string进行分组，使得两个组的最大括号深度最小
    // 其实也就是计算每个括号所在的深度，然后将奇偶深度的括号分别划到两个数组中即可
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        int level = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                level++;
                if ((level & 1) == 0) {
                    res[i] = 1;
                }
            } else {
                if ((level & 1) == 0) {
                    res[i] = 1;
                }
                level--;
            }
        }
        return res;
    }
}
