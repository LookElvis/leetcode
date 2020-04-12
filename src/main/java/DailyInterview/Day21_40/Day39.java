package DailyInterview.Day21_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * Created by Elvis on 2020/4/10.
 */
public class Day39 {
    public static void main(String[] args) {
        Day39 day39 = new Day39();
        String s = "  hello world!  ";
        System.out.println(day39.reverseWords(s));
    }

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords1(String s) {
        s = s.trim();
        String[] strings = s.split(" ");
        List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
//            System.out.println(strings[i]);
            if (strings[i] != " " && strings[i].length() != 0) {
                wordList.add(strings[i]);
            }
        }
        return String.join(" ", wordList);
    }
}
