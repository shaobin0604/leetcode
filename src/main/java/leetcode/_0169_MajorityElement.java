package leetcode;


import java.util.HashMap;

// https://leetcode-cn.com/problems/majority-element/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-4-2/
public class _0169_MajorityElement {
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int before = map.getOrDefault(nums[i], 0);
            if (before == n / 2) {
                return nums[i];
            }
            map.put(nums[i], before + 1);
        }
        //随便返回一个
        return -1;
    }

    public int majorityElement2(int[] nums) {
        int majority = 0;
        int n = nums.length;
        //判断每一位
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            int bits = 0;
            //记录当前列 1 的个数
            for (int j = 0; j < n; j++) {
                if ((mask & nums[j]) == mask) {
                    bits++;
                }
            }
            //当前列 1 的个数是否超过半数
            if (bits > n / 2) {
                majority |= mask;
            }
        }
        return majority;
    }

    public int majorityElement3(int[] nums) {
        int count = 1;
        int group = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //当前队伍人数为零，记录现在遇到的人的队伍号
            if (count == 0) {
                count = 1;
                group = nums[i];
                continue;
            }
            //现在遇到的人和当前队伍同组，人数加 1
            if (nums[i] == group) {
                count++;
                //遇到了其他队伍的人，人数减 1
            } else {
                count--;
            }
        }
        return group;
    }

}
