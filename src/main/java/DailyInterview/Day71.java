package DailyInterview;

import PublicClass.Utils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * 拓扑排序
 * Created by Elvis on 2020/5/17.
 */
public class Day71 {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][] {
                {1, 0},
                {1, 2},
                {0, 1}
        };
        Day71 day71 = new Day71();
        int[] res = day71.findOrder(numCourses, prerequisites);
        Utils.printIntArrays(res);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //记录每门课程的入度
        int[] inDegree = new int[numCourses];
        //记录每门课程是否访问过
        boolean[] isVisited = new boolean[numCourses];
        //存储依赖关系
        Map<Integer, List<Integer>> map = new HashMap<>();
        //记录最终的结果
        Queue<Integer> queue = new ArrayDeque<>();
        //初始化
        for (int i = 0; i < prerequisites.length; i++) {
            int pre = prerequisites[i][1];
            int suf = prerequisites[i][0];
            inDegree[suf]++;
            List<Integer> tList = map.get(pre);
            if (tList == null) {
                tList = new ArrayList<>();
                map.put(pre, tList);
            }
            tList.add(suf);
        }

        while (queue.size() != numCourses + 1) {
            // 获取入度为0的课程
            int tCourse = -1;
            for (int i = 0; i < inDegree.length; i++) {
                if (!isVisited[i] && inDegree[i] == 0) {
                    tCourse = i;
                    isVisited[i] = true;
                    break;
                }
            }
            //没找到入度为0的课程
            if (tCourse == -1) {
                break;
            }
            //处理入度为0的课程，加入结果集合并将其value的入度减1
            queue.add(tCourse);
            List<Integer> rList = map.get(tCourse);
            if (rList != null) {
                for (Integer t: rList) {
                    inDegree[t]--;
                }
            }
        }
        //结果转化
        return queue.size() == numCourses ?  queue.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
}
