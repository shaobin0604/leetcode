package leetcode;

public class _0278_FirstBadVersion {
    private final int firstBadVersion;
    private int methodCallCount = 0;

    public _0278_FirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    private boolean isBadVersion(int version) {
        methodCallCount++;
        System.out.println("count: " + methodCallCount);
        return version >= firstBadVersion;
    }

    public int firstBadVersion(int n) {
        long low = 1;
        long high = n;
        int mid = 1;
        int lastBadVersion = 1;
        while (low <= high) {
            mid = (int) ((low + high) / 2);
            if (isBadVersion(mid)) {
                high = mid - 1;
                lastBadVersion = mid;
            } else {
                low = mid + 1;
            }
        }
        return lastBadVersion;
    }

    // 官方题解
    public int firstBadVersion2(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int firstBadVersion3(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = (left + right) >>> 1;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
