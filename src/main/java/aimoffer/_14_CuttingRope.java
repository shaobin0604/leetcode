package aimoffer;

public class _14_CuttingRope {

    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }

        int[] product = new int[n + 1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3;

        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i/2; j++) {
                int result = product[j] * product[i - j];
                if (result > max) {
                    max = result;
                }
            }
            product[i] = max;
        }

        return product[n];
    }
}
