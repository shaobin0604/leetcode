package aimoffer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _09_SimulateStackWithTwoQueuesTest {

    @Test
    public void test_stack_operation_1() {
        List<Integer> result = new ArrayList<>();

        _09_SimulateStackWithTwoQueues<Integer> stack = new _09_SimulateStackWithTwoQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        result.add(stack.pop());
        result.add(stack.pop());
        result.add(stack.pop());

        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, result.toArray(new Integer[0]));
    }

    @Test
    public void test_stack_operation_2() {
        List<Integer> result = new ArrayList<>();

        _09_SimulateStackWithTwoQueues<Integer> stack = new _09_SimulateStackWithTwoQueues<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        result.add(stack.pop());
        result.add(stack.pop());
        stack.push(4);
        result.add(stack.pop());
        result.add(stack.pop());

        Assert.assertArrayEquals(new Integer[]{3, 2, 4, 1}, result.toArray(new Integer[0]));
    }
}
