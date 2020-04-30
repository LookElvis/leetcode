package DailyInterview;

/**
 * https://leetcode-cn.com/problems/find-in-mountain-array/
 * 暂未进行二分的细节处理
 * Created by Elvis on 2020/4/29.
 */
public class Day56_ForDetail {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        if (mountainArr.length() < 100) {
            for (int i = 0; i < mountainArr.length(); i++) {
                if (mountainArr.get(i) == target) {
                    return i;
                }
            }
            return -1;
        }

        int l = 0;
        int r = mountainArr.length() - 1;
        int m, t, t1, t2, res1 = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            t = mountainArr.get(m);
            t1 = mountainArr.get(m - 1);
            t2 = mountainArr.get(m + 1);
            // System.out.println(m + " " + t + " " + t1 + " " + t2);
            if (t > t1 && t > t2) {
                res1 = m;
                break;
            }
            if (t < t2) {
                l = m + 1;
            } else if (t < t1) {
                r = m - 1;
            }
        }
        // System.out.println(res1);

        int i1 = -1, i2 = -1;
        l = 0;
        r = res1 - 1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            t = mountainArr.get(m);
            if (t == target) {
                i1 = m;
                break;
            } else if (t < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        if (i1 != -1) {
            return i1;
        }

        l = res1 + 1;
        r = mountainArr.length() - 1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            t = mountainArr.get(m);
            if (t == target) {
                i2 = m;
                break;
            } else if (t < target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return i2;
    }
}

// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);
    public int length();
}

