package DailyInterview.Day1_20;

import PublicClass.Utils;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * Created by Elvis on 2020/3/6.
 */
public class Day4 {
    public static void main(String[] args) {
        int target = 15;
        Day4 day4 = new Day4();
        int[][] res = day4.findContinuousSequence(target);
        Utils.printIntMatrix(res);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        if(target <= 2){
            return null;
        }
        for(int i = 1; i <= target / 2 + 1; i++){
            int temp = target;
            int count = i;
            while (temp > 0) {
                temp = temp - count;
                count++;
            }
            if (temp == 0) {
                int[] arr = new int[count - i];
                int a = i;
                for (int j = 0;j < arr.length; j++) {
                    arr[j] = a;
                    a++;
                }
                res.add(arr);
            }
        }
        return res.toArray(new int[0][]);
    }
}
