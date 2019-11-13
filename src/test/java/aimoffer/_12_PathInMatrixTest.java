package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _12_PathInMatrixTest {
    @Test
    public void test_has_path_in_matrix() {
        final char[] array = {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        final int rows = 3;
        final int cols = 4;
        final char[] str = {'b', 'f', 'c', 'e'};

        Assert.assertTrue(new _12_PathInMatrix().hasPath(array, rows, cols, str));
    }
}
