package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.zip.CheckedInputStream;

public class _0215_KthLargestElementInAnArray {
    // 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            Arrays.parallelSort(nums);
            return nums[nums.length - k];
        }
    }

    // 堆 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
    static class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(2);
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    queue.offer(nums[i]);
                } else if (nums[i] > queue.peek()) {
                    queue.offer(nums[i]);
                    queue.poll();
                }
            }
            return queue.peek();
        }
    }


    static class Solution3 {
        public int findKthLargest(int[] nums, int k) {
            int targetIndex = nums.length - k;
            int left = 0, right = nums.length - 1;
            while (true) {
                int index = partition(nums, left, right);
                if (index == targetIndex) {
                    return nums[index];
                } else if (index < targetIndex) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            int low = left, high = right;
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] > pivot) {
                    high--;
                }

                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                if (low < high) {
                    swap(nums, low, high);
                }
            }
            swap(nums, left, low);

            return low;
        }

        private int partition2(int[] nums, int left, int right) {
            int pivot = nums[left];
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, i, index);
                    index++;
                }
            }
            swap(nums, left, index - 1);
            return index - 1;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
