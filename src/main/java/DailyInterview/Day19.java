package DailyInterview;

/**
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 * 还可以用DFS，使用栈进行遍历，用HashSet存储已经走过的路径，栈空结束返回false
 * Created by Elvis on 2020/3/21.
 */
public class Day19 {
    public static void main(String[] args) {
        Day19 day19 = new Day19();
        int x = 3;
        int y = 4;
        int z = 5;
        System.out.println(day19.canMeasureWater(x, y, z));
    }

    // 水池中的水每次只会变化x或者y，因此只要存在整数a、b，使得ax+by=z即可
    // 如果z可以整除x、y的最大公约数，即满足该式
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % calGCD(x, y) == 0;
    }

    public int calGCD(int x, int y) {
        int t = x;
        for (int i = 1; i <= t; i++) {
            int c = x > y ? x : y;//两个数字的大值
            int d = x < y ? x : y;//两个数字的小值
            x = c % d;
            y = d;
            if (x == 0) {
                return d;
            }
        }
        return -1;
    }
}
