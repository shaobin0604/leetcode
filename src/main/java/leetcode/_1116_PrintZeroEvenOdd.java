package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1116_PrintZeroEvenOdd {
    private int n;
    private Semaphore even;
    private Semaphore odd;
    private Semaphore zero;

    public _1116_PrintZeroEvenOdd(int n) {
        this.n = n;
        even = new Semaphore(0);
        odd = new Semaphore(0);
        zero = new Semaphore(1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if ((i & 1) == 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        final _1116_PrintZeroEvenOdd instance = new _1116_PrintZeroEvenOdd(1);
        final IntConsumer printNumber = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.zero(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.even(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    instance.odd(printNumber);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
