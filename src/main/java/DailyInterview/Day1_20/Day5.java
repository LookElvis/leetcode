package DailyInterview.Day1_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Elvis on 2020/3/7.
 */
public class Day5 {
    public static void main(String[] args) {

    }

    Deque<Integer> queue;
    Deque<Integer> helper;
    public Day5() {
        queue = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public int max_value() {
        return queue.isEmpty() ? -1 : helper.peek();
    }

    public void push_back(int value) {
        queue.add(value);
        while (!helper.isEmpty() && value > helper.peekLast()) {
            helper.pollLast();
        }
        helper.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int val = queue.poll();
        if (helper.peek() == val) {
            helper.poll();
        }
        return val;
    }
}
