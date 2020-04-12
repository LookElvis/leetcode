package DailyInterview.Day21_40;


/**
 * https://leetcode-cn.com/submissions/detail/57260632/
 * Created by Elvis on 2020/3/27.
 */
public class Day25 {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] m = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            m[deck[i]]++;
        }
        int g = -1;
        for (int i = 0; i < deck.length; i++) {
            if (m[i] > 0) {
                if (g == -1) {
                    g = m[i];
                } else {
                    g = gcd(g, m[i]);
                }
            }
        }
        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
