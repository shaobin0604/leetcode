package aimoffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _59_MaxQueue {

    static class MaxQueue {
        private Queue<Integer> queue;
        private Deque<Integer> deque;


        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            final Integer max = deque.peekFirst();
            return max == null ? -1 : max;
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_front() {
            final Integer peek = queue.poll();
            if (peek == null) {
                return -1;
            }

            if (peek.equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return peek;
        }
    }
}
