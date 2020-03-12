package DailyInterview;

import PublicClass.Utils;

/**
 * https://leetcode-cn.com/problems/distribute-candies-to-people/
 * Created by Elvis on 2020/3/5.
 */
public class Day3 {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        int candies = 23;
        int num_people = 3;
        int[] m = day3.distributeCandies(candies, num_people);
        Utils.printIntArrays(m);
    }

    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int line = 0;
        while (true) {
            if ((1 + n) * n <= candies * 2) {
                n += num_people;
                line++;
            } else {
                n -= num_people;
                break;
            }
        }
        int rest = candies - (1 + n) * n / 2;
        System.out.println("n " + n + " line " + line + " rest " + rest);
        int[] m = new int[num_people];
        int t = 1;
        if (n != 0) {
            for (int i = 0; i < num_people; i++) {
                m[i] = (i + 1) * line + line * (line - 1) * num_people / 2;
                System.out.println(i + " " + m[i]);
            }
            t = n + 1;
        }

        for (int i = 0; i < num_people; i++) {
            if (rest <= t) {
                m[i] += rest;
                break;
            } else {
                rest -= t;
                m[i] += t;
                t++;
            }
        }
        return m;
    }
}
