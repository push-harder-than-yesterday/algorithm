package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        solution.getMin(); // return -3
        solution.pop();
        solution.top();    // return 0
        solution.getMin(); // return -2
    }

    private static class Solution {
        List<Integer> list;
        /** initialize your data structure here. */
        public Solution() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public void pop() {
            list.remove(list.size() - 1);
        }

        public int top() {
            System.out.println("top() result: " + list.get(list.size() - 1));
            return list.get(list.size() - 1);
        }

        public int getMin() {
            int min = Integer.MAX_VALUE;
            for (int item : list) {
                min = Math.min(min, item);
            }

            System.out.println("getMin() result: " + min);
            return min;
        }
    }
}
