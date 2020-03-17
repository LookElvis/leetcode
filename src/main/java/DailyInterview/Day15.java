package DailyInterview;

/**
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/submissions/
 * Created by Elvis on 2020/3/17.
 */
public class Day15 {
    public int countCharacters(String[] words, String chars) {
        int[] countChar = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            countChar[chars.charAt(i) - 'a']++;
        }

        // for (int i = 0; i < countChar.length; i++) {
        //     System.out.print(countChar[i] + " ");
        // }
        // System.out.println();

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String t = words[i];
            int j = 0;
            boolean isMatch = true;
            for (; j < t.length(); j++) {
                if (--countChar[t.charAt(j) - 'a'] < 0) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                count += t.length();
            }
            for (int k = 0; k <= j && k < t.length(); k++) {
                countChar[t.charAt(k) - 'a']++;
            }

            // for (int m = 0; m < countChar.length; m++) {
            //     System.out.print(countChar[m] + " ");
            // }
            // System.out.println();
        }

        return count;
    }

}
