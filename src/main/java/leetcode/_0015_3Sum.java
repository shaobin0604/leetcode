package leetcode;

import java.util.*;

public class _0015_3Sum {
    // dfs 组合总数超时
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }

            Arrays.sort(nums);

            Set<List<Integer>> ans = new HashSet<>();
            Stack<Integer> path = new Stack<>();
            dfs(ans, path, nums, 0);

            return new ArrayList<>(ans);
        }

        private void dfs(Set<List<Integer>> ans, Stack<Integer> path, int[] nums, int start) {
            if (path.size() == 3) {
                if (sum(path) == 0) {
                    ans.add(new ArrayList<>(path));
                }
                return;
            }

            for (int i = start; i < nums.length; i++) {
                path.push(nums[i]);
                dfs(ans, path, nums, i + 1);
                path.pop();
            }
        }

        private int sum(Stack<Integer> path) {
            int sum = 0;
            for (Integer i : path) {
                sum += i;
            }
            return sum;
        }
    }

    static class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            if (nums.length < 3) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();

            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if (nums[i] > 0) {
                    break;
                }

                //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
                if (i == 0 || (nums[i] != nums[i - 1])) {
                    int sum = -nums[i];
                    int lo = i + 1;
                    int hi = nums.length - 1;

                    while (lo < hi) {
                        if (nums[lo] + nums[hi] == sum) {
                            ans.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                            //元素相同要后移，防止加入重复的 list
                            while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi - 1]) hi--;

                            lo++;
                            hi--;
                        } else if (nums[lo] + nums[hi] > sum) {
                            hi--;
                        } else {
                            lo++;
                        }
                    }
                }

            }

            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
