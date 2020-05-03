package DailyInterview.Day41_60;

/**
 * Created by Elvis on 2020/4/18.
 */
public class Day45 {
    public static void main(String[] args) {
        Day45 day45 = new Day45();
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int res = day45.maxArea(height);
        System.out.println(res);
    }

    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (p1 < p2) {
            int area = Math.min(height[p1], height[p2]) * (p2 - p1);
            max = Math.max(max, area);
            if (height[p1] <= height[p2]) {
                p1++;
            } else {
                p2--;
            }
        }
        return max;
    }
}
