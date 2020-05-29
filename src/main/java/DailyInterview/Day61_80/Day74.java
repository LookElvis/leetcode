package DailyInterview.Day61_80;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * Created by Elvis on 2020/5/20.
 */
public class Day74 {
    public static void main(String[] args) {
        Day74 day74 = new Day74();
        String s = "eleetminicoworoep";
        int res = day74.findTheLongestSubstring(s);
        System.out.println(res);
    }

    public int findTheLongestSubstring(String s) {
        //用于存储第一次出现该奇偶状态的下标位置
        int[] pos = new int[(1 << 5)];
        Arrays.fill(pos, -1);
        //从1开始计数，到31
        pos[0] = 0;
        int res = 0;
        //用于记录直到当前字符，元音出现的奇偶性
        int status = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                //异或，0变1，1变0
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            //查看到当前字符，当前元音的奇偶状态是否已经出现
            if (pos[status] >= 0) { //出现
                res = Math.max(res, i + 1 - pos[status]);
            } else { //未出现
                pos[status] = i + 1;
            }
        }
        return res;
    }
}
