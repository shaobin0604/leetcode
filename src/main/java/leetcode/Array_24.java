package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Array_24 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> marks = new HashSet<>();

        for (int num : nums) {
            if (marks.contains(num)) {
                return true;
            } else {
                marks.add(num);
            }
        }

        return false;
    }
}
