package DailyInterview;

import PublicClass.Utils;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * Created by Elvis on 2020/4/28.
 */
public class Day55 {
    public static void main(String[] args) {
        Day55 day55 = new Day55();
        int[] arr = new int[] {6,5,5,9,10,9,4,10};
        int[] res = day55.singleNumbers(arr);
        Utils.printIntArrays(res);
    }

    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum ^= nums[i];
        }
//        System.out.println(sum + "  " + (4 ^ 6));

        //计算哪一位是1
        int index = 0;
        while (sum != 0) {
            if ((sum & 1) == 1) {
                break;
            }
            sum >>= 1;
            index++;
        }
//        System.out.println(index);

        //根据该位将两个不重复出现的数字分组
        int sum1 = 0;
        int sum2 = 0;
        int t;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> index) & 1) == 1) {
                sum1 ^= nums[i];
            } else {
                sum2 ^= nums[i];
            }
        }
        return new int[]{sum1, sum2};
    }
}
