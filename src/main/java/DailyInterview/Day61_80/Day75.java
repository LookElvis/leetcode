package DailyInterview.Day61_80;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * Created by Elvis on 2020/5/21.
 */
public class Day75 {
    public static void main(String[] args) {
        Day75 day75 = new Day75();
        String s = "eleetminicoworoep";
        String res = day75.longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);//回文长度为奇数
            int len2 = expand(s, i, i + 1);//回文长度为偶数
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //以left，right为中心开始往两边扩展的回文长度
    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
