package DailyInterview.Day61_80;

/**
 * 快速幂
 * https://leetcode-cn.com/problems/powx-n/
 * Created by Elvis on 2020/5/11.
 */
public class Day65 {
    public double myPow(double x, int n) {
        long N = n;
        return n >= 0 ? quickCal(x, N) : 1 / quickCal(x, -N);
    }

    public double quickCal(double x, long n) {
        double res = 1.0;
        double tx = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= tx;
            }
            tx *= tx;
            n /= 2;
        }
        return res;
    }
}
