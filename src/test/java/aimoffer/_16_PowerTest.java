package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _16_PowerTest {
    @Test
    public void test_case() {
        final _16_Power power = new _16_Power();
        Assert.assertEquals(0, power.power(0, 1), 0.0000001);
        Assert.assertEquals(4, power.power(-2, 2), 0.0000001);
        Assert.assertEquals(0.25, power.power(-2, -2), 0.0000001);
    }
}
