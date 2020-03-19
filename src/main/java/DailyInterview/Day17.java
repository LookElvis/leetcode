package DailyInterview;

/**
 * https://leetcode-cn.com/problems/longest-palindrome/
 * Created by Elvis on 2020/3/19.
 */
public class Day17 {
    public int longestPalindrome(String s) {
        int[] chars = new int[52];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t <= 'Z') {
                chars[t - 'A']++;
                if ((chars[t - 'A'] & 1) == 0) {
                    count += chars[t - 'A'];
                    chars[t - 'A'] = 0;
                }
            } else {
                chars[26 + t - 'a']++;
                if ((chars[26 + t - 'a'] & 1) == 0) {
                    count += chars[26 + t - 'a'];
                    chars[26 + t - 'a'] = 0;
                }
            }

        }

        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] & 1) == 1) {
                return count + 1;
            }
        }
        return count;
    }
}
