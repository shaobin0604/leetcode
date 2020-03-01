package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0225_ImplementStackUsingQueues {
    static class MyStack {

        public static final int COUNT = 2;
        private Queue<Integer>[] queues;
        private int current;
        private int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queues = new LinkedList[COUNT];
            for (int i = 0; i < COUNT; i++) {
                queues[i] = new LinkedList<>();
            }
            current = 0;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queues[current].offer(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int next = (current + 1) % COUNT;

            while (queues[current].size() > 1) {
                final Integer e = queues[current].poll();
                queues[next].offer(e);
                top = e;
            }

            int oldTop = queues[current].poll();
            current = next;
            return oldTop;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queues[current].isEmpty();
        }
    }

    static class MyStack2 {

        private Queue<Integer> queue;
        private int top;

        /**
         * Initialize your data structure here.
         */
        public MyStack2() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                final Integer e = queue.poll();
                queue.offer(e);
                top = e;
            }
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return top;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyStack obj = new MyStack();
        obj.push(2);
        obj.push(3);
        obj.push(4);
        int param_2 = obj.pop();

        System.out.println(param_2);

        int param_3 = obj.top();

        System.out.println(param_3);

        boolean param_4 = obj.empty();

        System.out.println(param_4);

    }
}
