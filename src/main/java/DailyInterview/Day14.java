package DailyInterview;

/**
 * https://leetcode-cn.com/problems/compress-string-lcci/
 * Created by Elvis on 2020/3/16.
 */
public class Day14 {
    public String compressString(String S) {
        if (S.length() == 0 || S == "") {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char t = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == t) {
                count++;
            } else {
                sb.append(t);
                sb.append(count);
                t = S.charAt(i);
                count = 1;
            }
        }
        sb.append(t);
        sb.append(count);
        return sb.length() < S.length() ? sb.toString() : S;
    }
}
