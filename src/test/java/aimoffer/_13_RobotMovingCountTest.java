package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _13_RobotMovingCountTest {
    @Test
    public void test_case_1() {
        final int rows = 3;
        final int cols = 3;
        final int threshold = 6;

        Assert.assertEquals(9, new _13_RobotMovingCount().movingCount(threshold, rows, cols));
    }
}
