package DailyInterview.Day61_80;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * Created by Elvis on 2020/5/9.
 */
public class Day63 {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(new Day63().mySqrt(4));
    }

    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
