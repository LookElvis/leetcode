package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by Elvis on 2020/4/9.
 */
public class M017_Letter_Combinations_Of_A_Phone_Number {
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == "" || digits.length() == 0) {
            return list;
        }
        generate("", 0, digits);
        return list;
    }

    public void generate(String res, int index, String digits) {
        if (index == digits.length()) {
            list.add(res);
            return;
        }
        switch(digits.charAt(index)) {
            case '2': {
                generate(res + "a", index + 1, digits);
                generate(res + "b", index + 1, digits);
                generate(res + "c", index + 1, digits);
                break;
            }
            case '3': {
                generate(res + "d", index + 1, digits);
                generate(res + "e", index + 1, digits);
                generate(res + "f", index + 1, digits);
                break;
            }
            case '4': {
                generate(res + "g", index + 1, digits);
                generate(res + "h", index + 1, digits);
                generate(res + "i", index + 1, digits);
                break;
            }
            case '5': {
                generate(res + "j", index + 1, digits);
                generate(res + "k", index + 1, digits);
                generate(res + "l", index + 1, digits);
                break;
            }
            case '6': {
                generate(res + "m", index + 1, digits);
                generate(res + "n", index + 1, digits);
                generate(res + "o", index + 1, digits);
                break;
            }
            case '7': {
                generate(res + "q", index + 1, digits);
                generate(res + "p", index + 1, digits);
                generate(res + "r", index + 1, digits);
                generate(res + "s", index + 1, digits);
                break;
            }
            case '8': {
                generate(res + "t", index + 1, digits);
                generate(res + "u", index + 1, digits);
                generate(res + "v", index + 1, digits);
                break;
            }
            case '9': {
                generate(res + "w", index + 1, digits);
                generate(res + "x", index + 1, digits);
                generate(res + "y", index + 1, digits);
                generate(res + "z", index + 1, digits);
                break;
            }
        }
    }
}
