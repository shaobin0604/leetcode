package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0046_Permutations {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);

        return result;
    }

    private void permute(int[] nums, int k) {
        if (k == nums.length) {
            List<Integer> serial = new ArrayList<>(nums.length);
            for (int num : nums) {
                serial.add(num);
            }
            result.add(serial);
            return;
        }

        for (int i = k; i < nums.length; i++) {
            swap(nums, k, i);

            permute(nums, k + 1);

            swap(nums, k, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        final _0046_Permutations permutations = new _0046_Permutations();
        permutations.permute(array);

        System.out.println(permutations.result);
    }

    public static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);

            return result;
        }

        private void backtrack(int[] nums, LinkedList<Integer> track) {
            if (track.size() == nums.length) {
                result.add(new LinkedList<Integer>(track));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i])) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择
                track.removeLast();
            }
        }
    }
}
