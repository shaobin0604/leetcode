package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

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
            PriorityQueue<Integer> queue = new PriorityQueue<>(k);
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

    // https://en.wikipedia.org/wiki/Quickselect
    // https://en.wikipedia.org/wiki/Quicksort
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

        // Hoare partition scheme
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

        // Lomuto partition scheme
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

        public int partition3(int[] nums, int left, int right, int pivot_index) {
            int pivot = nums[pivot_index];
            // 1. move pivot to end
            swap(nums, pivot_index, right);
            int store_index = left;

            // 2. move all smaller elements to the left
            for (int i = left; i <= right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, store_index, i);
                    store_index++;
                }
            }

            // 3. move pivot to its final place
            swap(nums, store_index, right);

            return store_index;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
