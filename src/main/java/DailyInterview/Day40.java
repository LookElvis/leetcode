package DailyInterview;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/super-egg-drop/
 * 高楼扔鸡蛋
 * Created by Elvis on 2020/4/11.
 */
public class Day40 {
    /**
     * 鸡蛋掉落，鹰蛋（Leetcode 887）：（经典dp）
     * 有 K 个鸡蛋，有 N 层楼，用最少的操作次数 F 检查出鸡蛋的质量。
     *
     * 思路：
     * 本题应该逆向思维，若你有 K 个鸡蛋，你最多操作 F 次，求 N 最大值。
     *
     * dp[k][f] = dp[k][f-1] + dp[k-1][f-1] + 1;
     * 解释：
     * 0.dp[k][f]：如果你还剩 k 个蛋，且只能操作 f 次了，所能确定的楼层。
     * 1.dp[k][f-1]：蛋没碎，因此该部分决定了所操作楼层的上面所能容纳的楼层最大值
     * 2.dp[k-1][f-1]：蛋碎了，因此该部分决定了所操作楼层的下面所能容纳的楼层最大值
     * 又因为第 f 次操作结果只和第 f-1 次操作结果相关，因此可以只用一维数组。
     *
     * 时复：O(K*根号(N))
     */
    public int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int ans = 0;    // 操作的次数
        while (dp[K] < N){
            for (int i = K; i > 0; i--) // 从后往前计算
                dp[i] = dp[i] + dp[i-1] + 1;
            ans++;
        }
        return ans;
    }

    //超出时间限制
    //设置备忘录，减少计算次数
    HashMap<String, Integer> map = new HashMap();
    // superEggDrop代表着在K个鸡蛋、N层楼的情况下，最少的尝试次数
    public int superEggDrop1(int K, int N) {
        // 鸡蛋个数为1时候需要遍历
        if (K == 1) {
            return N;
        }
        // 楼层为0尝试次数也为0
        if (N == 0) {
            return 0;
        }
        // 如果已经计算过
        if (map.containsKey(K + "-" + N)) {
            return map.get(K + "-" + N);
        }
        int res = Integer.MAX_VALUE;
        // 此次扔鸡蛋尝试的楼层，找到此状态下应该在第几层楼扔鸡蛋才能够使得尝试次数最少
        for (int i = 1; i <= N; i++) {
            res = Math.min(res,
                    // 在当前楼层扔鸡蛋分为 碎和不碎 两种状态，返回这个状态下的最坏情况
                    Math.max(superEggDrop1(K - 1, i - 1), superEggDrop1(K, N - i)) + 1
            );
        }
        map.put(K + "-" + N, res);
        return res;
    }
}
