package DailyInterview;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * 可以用快慢指针破循环，快指针每次计算两次，慢指针计算一次
 * Created by Elvis on 2020/4/30.
 */
public class Day57 {
    public static void main(String[] args) {
        Day57 day57 = new Day57();
        int n = 356546435;
        System.out.println(day57.isHappy(n));
    }

    public boolean isHappy(int n) {
        int cnt, t;
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            cnt = 0;
            while (n != 0) {
                t = n % 10;
                cnt += getMul(t);
                n /= 10;
            }
            System.out.println(cnt);
            if (set.contains(cnt)) {
                return false;
            } else {
                set.add(cnt);
                n = cnt;
            }
        }
        return true;
    }

    public int getMul(int t) {
        if (t == 0) {
            return 0;
        } else if (t == 1) {
            return 1;
        } else if (t == 2) {
            return 4;
        } else if (t == 3) {
            return 9;
        } else if (t == 4) {
            return 16;
        } else if (t == 5) {
            return 25;
        } else if (t == 6) {
            return 36;
        } else if (t == 7) {
            return 49;
        } else if (t == 8) {
            return 64;
        } else {
            return 81;
        }
    }
}
