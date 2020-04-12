package DailyInterview.Day21_40;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Created by Elvis on 2020/4/3.
 */
public class Day32 {
    public static void main(String[] args) {
        Day32 day32 = new Day32();
        String str = "9223372036854775808";
//        String str = "-91283472332";
        System.out.println(day32.myAtoi(str));
    }

    public int myAtoi(String str) {
        boolean posOrNeg = true;
        boolean isZero = true;
        boolean isBegin = false;
        long res = 0;
        char t;
        for (int i = 0; i < str.length(); i++) {
            t = str.charAt(i);
            if (!isBegin && t != ' ') {
                isBegin = true;
                if (t == '-') {
                    posOrNeg = false;
                } else if (t == '+') {
                    posOrNeg = true;
                } else if (t < '0' || t > '9') {
                    return 0;
                } else {
                    isZero = false;
                    res *= 10;
                    res += t - '0';
                }
            } else if (isBegin) {
                if (t < '0' || t > '9') {
                    break;
                } else {
                    isZero = false;
                    res *= 10;
                    res += t - '0';
                }
            }
            //判断计算过程中是否超出界限
            if (res > Integer.MAX_VALUE || -res < Integer.MIN_VALUE) {
                break;
            }
        }

        if (isZero) {
            return 0;
        }
        if (posOrNeg) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
        } else {
            return -res < Integer.MIN_VALUE ? Integer.MIN_VALUE : -(int)res;
        }
    }
}
