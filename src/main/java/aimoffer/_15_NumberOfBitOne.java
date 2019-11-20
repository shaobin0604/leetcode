package aimoffer;

public class _15_NumberOfBitOne {
    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }

    public int numberOf1V2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            // 考虑到存在负数的情况，进行无符号右移
            n >>>= 1;
        }
        return count;
    }

    public int numberOf1V3(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }
}
