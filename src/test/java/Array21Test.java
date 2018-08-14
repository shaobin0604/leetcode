import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Array21Test {
    @Test
    public void test_removeDuplicates1() {
        final int[] nums = {1, 1, 2};
        final int len = new Array21().removeDuplicates(nums);
        Assert.assertEquals(2, len);
        Assert.assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, len));


    }

    @Test
    public void test_removeDuplicates2() {
        final int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        final int len = new Array21().removeDuplicates(nums);
        Assert.assertEquals(5, len);
        Assert.assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, len));
    }
}
