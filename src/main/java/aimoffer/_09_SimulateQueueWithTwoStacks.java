package aimoffer;

import java.util.Stack;

public class _09_SimulateQueueWithTwoStacks<T> {
    Stack<T> in = new Stack<>();
    Stack<T> out = new Stack<>();

    public void push(T node) {
        in.push(node);
    }

    public T pop() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());

        if (out.isEmpty())
            throw new RuntimeException("queue is empty");

        return out.pop();
    }
}
