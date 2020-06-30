package DailyInterview;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * 两个栈实现队列
 * Created by elvisxliu
 * date: 2020/6/30
 */
public class Day85 {
}

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) {
                return -1;
            } else {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    int t = stack1.pop();
                    stack2.push(t);
                }
                return stack2.pop();
            }
        }
    }
}
