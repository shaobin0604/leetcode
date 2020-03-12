package leetcode;

public class _1013_PartitionArrayIntoThreePartsWithEqualSum {
    static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            int partSum = 0;
            for (int x : A) {
                sum += x;
            }

            if (sum % 3 != 0) {
                return false;
            }

            int part = sum / 3;
            int i = 0;
            while (i < A.length - 2) {
                partSum += A[i];
                if (partSum == part) {
                    break;
                }
                i++;
            }
            if (i >= A.length - 2) {
                return false;
            }

            int j = i + 1;
            partSum = 0;
            while (j < A.length - 1) {
                partSum += A[j];
                if (partSum == part) {
                    break;
                }
                j++;
            }
            return j < A.length - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})); // true
        System.out.println(solution.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1})); // false
        System.out.println(solution.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4})); // true
    }
}
