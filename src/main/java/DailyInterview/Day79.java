package DailyInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * Created by Elvis on 2020/5/27.
 */
public class Day79 {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod, 0);
            ans += same;
            map.put(mod, same + 1);
        }
        return ans;
    }
}
