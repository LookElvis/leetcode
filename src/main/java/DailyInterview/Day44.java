package DailyInterview;

import PublicClass.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/jump-game/
 * Created by Elvis on 2020/4/15.
 */
public class Day44 {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 4},
                {4, 6},
                {2, 5},
                {12, 16}
        };
        Day44 day44 = new Day44();
        int[][] res = day44.merge(intervals);
        Utils.printIntMatrix(res);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a ,b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int start = intervals[0][0];
        int end =  intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[0][]);
    }
}
