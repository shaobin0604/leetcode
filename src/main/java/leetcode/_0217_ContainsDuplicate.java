package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> marks = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if (marks.contains(num)) {
                return true;
            } else {
                marks.add(num);
            }
        }

        return false;
    }
}
