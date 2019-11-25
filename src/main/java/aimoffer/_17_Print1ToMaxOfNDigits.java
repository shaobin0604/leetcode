package aimoffer;

public class _17_Print1ToMaxOfNDigits {

    public static void main(String[] args) {
        new _17_Print1ToMaxOfNDigits().print1ToMaxNDigits(2);
    }

    public void print1ToMaxNDigits(int n) {
        if (n <= 0) {
            return;
        }

        final char[] number = new char[n];

        print1ToMaxNDigits(number, 0);
    }

    private void print1ToMaxNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[digit] = (char)(i + '0');
            print1ToMaxNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int i = 0;

        // skip preceding zero digit
        while (i < number.length && number[i] == '0') {
            i++;
        }

        while (i < number.length) {
            System.out.print(number[i++]);
        }

        System.out.println();
    }
}
