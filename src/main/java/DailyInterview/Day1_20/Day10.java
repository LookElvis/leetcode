package DailyInterview.Day1_20;

/**
 * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/
 * Created by Elvis on 2020/3/12.
 */
public class Day10 {
    public static void main(String[] args) {

    }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int num = getNum(str1.length(), str2.length());
        return str1.substring(0, num);
    }

    // 求最大公约数
    public int getNum(int num1, int num2) {
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        while (num2 != 0) {
            int tmp = num1 % num2;
            num1 = num2;
            num2 = tmp;
        }
        return num1;
    }
}
