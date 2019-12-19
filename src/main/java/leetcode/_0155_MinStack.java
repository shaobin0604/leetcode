package leetcode;

import java.util.Stack;

public class _0155_MinStack {

    static class MinStack {
        private Stack<Element> stack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new Element(x, x));
                return;
            }

            final Element top = stack.peek();
            stack.push(new Element(x, Math.min(x, top.min)));
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek().value;
        }

        public int getMin() {
            return stack.peek().min;
        }

        private static final class Element {
            final int value;
            final int min;

            Element(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }


    static class MinStack2 {
        private Stack<Long> stack;
        private long min;

        /** initialize your data structure here. */
        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                min = x;
                stack.push(x - min);
            } else {
                stack.push(x - min);
                min = Math.min(x, min);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                return;
            }

            final Long top = stack.pop();
            if (top < 0) {
                min = min - top;
            }
        }

        public int top() {
            final Long top = stack.peek();
            if (top < 0) {
                return (int) min;
            } else {
                return (int) (top + min);
            }
        }

        public int getMin() {
            return (int) min;
        }
    }
}
