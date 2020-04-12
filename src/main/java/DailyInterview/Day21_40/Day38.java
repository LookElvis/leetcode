package DailyInterview.Day21_40;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * Created by Elvis on 2020/4/9.
 */
public class Day38 {
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return list;
        }
        String res = "(";
        int index = 1;
        int leftCount = 1;
        int rightCount = 0;
        generate(res, index, leftCount, rightCount, n);
        return list;
    }

    public void generate(String s, int index, int leftCount, int rightCount, int n) {
        if (index == 2 * n - 1) {
            list.add(s + ")");
            return;
        }
        if (leftCount < n) {
            generate(s + "(", index + 1, leftCount + 1, rightCount, n);
        }

        if (leftCount != rightCount) {
            generate(s + ")", index + 1, leftCount, rightCount + 1, n);
        }
    }
}
