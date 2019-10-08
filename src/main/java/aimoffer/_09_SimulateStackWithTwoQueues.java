package aimoffer;

import java.util.LinkedList;
import java.util.Queue;

public class _09_SimulateStackWithTwoQueues<T> {

    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T e) {
        Queue<T> queueOffer = queue1.isEmpty() ? queue2 : queue1;
        queueOffer.offer(e);
    }

    public T pop() {
        Queue<T> queuePoll = queue1.isEmpty() ? queue2 : queue1;
        Queue<T> queueOffer = queue1.isEmpty() ? queue1 : queue2;
        while (queuePoll.size() > 1) {
            queueOffer.offer(queuePoll.poll());
        }
        return queuePoll.poll();
    }

}
