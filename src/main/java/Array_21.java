public class Array_21 {


    public int removeDuplicates(int[] nums) {


        if (nums.length < 2) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                j++;
            } else {
                j = findFirstNotEqualIndex(nums, i, j + 1);
                if (j < nums.length) {
                    nums[i + 1] = nums[j];
                    i++;
                }
            }
        }
        return i + 1;
    }

    private int findFirstNotEqualIndex(int[] nums, int i, int j) {
        final int item = nums[i];
        final int length = nums.length;
        while (j < length) {
            if (nums[j] != item) {
                return j;
            }
            j++;
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3};

        final int len = new Array_21().removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]);
        }

    }
}
