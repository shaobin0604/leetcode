package leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1195_FizzBuzzMultithreaded {
    private int n;
    private Semaphore fSem = new Semaphore(0);
    private Semaphore bSem = new Semaphore(0);
    private Semaphore fbSem = new Semaphore(0);
    private Semaphore nSem = new Semaphore(1);

    public _1195_FizzBuzzMultithreaded(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fSem.acquire();
                printFizz.run();
                nSem.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                bSem.acquire();
                printBuzz.run();
                nSem.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fbSem.acquire();
                printFizzBuzz.run();
                nSem.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            nSem.acquire();
            if (i % 3 == 0 && i % 5 == 0) {
                fbSem.release();
            } else if (i % 3 == 0) {
                fSem.release();
            } else if (i % 5 == 0) {
                bSem.release();
            } else {
                printNumber.accept(i);
                nSem.release();
            }
        }
    }

    public static void main(String[] args) {
        final _1195_FizzBuzzMultithreaded instance = new _1195_FizzBuzzMultithreaded(15);
        final IntConsumer printNumber = new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.print(value);
            }
        };

        Thread t1 = new Thread(() -> {
            try {
                instance.fizz(() -> System.out.print(", fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                instance.buzz(() -> System.out.print(", buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                instance.fizzbuzz(() -> System.out.print(", fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                instance.number(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
