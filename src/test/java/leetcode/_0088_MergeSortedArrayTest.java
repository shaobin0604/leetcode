package leetcode;

import org.junit.Assert;
import org.junit.Test;

import leetcode._0088_MergeSortedArray;

public class _0088_MergeSortedArrayTest {
    @Test
    public void test_case1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;

        new _0088_MergeSortedArray().merge(nums1, m, nums2, n);
        final int[] expected = {1, 2, 2, 3, 5, 6};
        Assert.assertArrayEquals(expected, nums1);
    }

    @Test
    public void test_case2() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;

        new _0088_MergeSortedArray().merge(nums1, m, nums2, n);
        final int[] expected = {1};
        Assert.assertArrayEquals(expected, nums1);
    }
}
