package week5.MinStack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * created by victory_woo on 2020/10/08
 */
public class woo {
    public static void main(String[] args) {

        MinStackImpl obj = new MinStackImpl();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin();
        obj.pop();
        obj.top();
        obj.getMin();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

    // stack 을 2개 사용하는 방법.
    static class MinStackImpl {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;
        private int min;

        MinStackImpl() {
            stack = new Stack<>();
            minStack = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        // minStack 에 정수값을 넣을 때는 비어있거나 minStack 의 peek 보다 작을 때만 넣어준다.
        void push(int x) {
            log("Push : " + x);
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) minStack.push(x);
        }

        // pop 할 때는 stack 은 무조건 빠지는데, minStack 은 stack 의 peek == minStack.peek 이어야 빠진다.
        void pop() {
            log("Pop : " + stack.peek());
            if (stack.peek().equals(minStack.peek())) minStack.pop();
            stack.pop();
        }

        int top() {
            log("Top : " + stack.peek());
            return stack.peek();
        }

        int getMin() {
            log("Min : " + minStack.peek());
            return minStack.peek();
        }

        void log(String message) {
            System.out.println(message);
        }
    }

    static class MinStack {
        private LinkedList<Integer> list;
        private int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            list = new LinkedList<>();
            reset();
        }

        public void push(int x) {
            log("Push : " + x);
            list.add(x);
        }

        public void pop() {
            log("Pop : " + list.getLast());
            list.removeLast();
            reset();
        }

        public int top() {
            log("Top : " + list.getLast());
            return list.getLast();
        }

        public int getMin() {
            for (int v : list) {
                if (v < min) min = v;
            }

            log("Min : " + min);
            return min;
        }

        void reset() {
            min = Integer.MAX_VALUE;
        }

        void log(String message) {
            System.out.println(message);
        }
    }


}
