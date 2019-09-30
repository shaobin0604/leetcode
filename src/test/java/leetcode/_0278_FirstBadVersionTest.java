package leetcode;

import org.junit.Assert;
import org.junit.Test;

import leetcode._0278_FirstBadVersion;

public class _0278_FirstBadVersionTest {
    @Test
    public void test_case1() {
        verify(3, 2);
    }

    @Test
    public void test_case2() {
        verify(5, 4);
    }

    @Test
    public void test_case3() {
        verify(2126753390, 1702766719);
    }

    private void verify(int versionCount, int firstBadVersion) {
        final _0278_FirstBadVersion instance = new _0278_FirstBadVersion(firstBadVersion);
        Assert.assertEquals(firstBadVersion, instance.firstBadVersion2(versionCount));
    }
}
