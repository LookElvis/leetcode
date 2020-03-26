package DailyInterview.Day1_20;

/**
 * https://leetcode-cn.com/problems/rectangle-overlap/submissions/
 * Created by Elvis on 2020/3/18.
 */
public class Day16 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2]) &&
                Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }
}
