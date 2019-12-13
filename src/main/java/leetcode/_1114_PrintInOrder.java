package leetcode;

import java.util.concurrent.CountDownLatch;

public class _1114_PrintInOrder {
    private final CountDownLatch countDownLatch1;
    private final CountDownLatch countDownLatch2;

    public _1114_PrintInOrder() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {
        _1114_PrintInOrder f = new _1114_PrintInOrder();

        for (int i = 0; i < 1; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    f.first(() -> {
                        System.out.print("1");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            Thread t2 = new Thread(() -> {
                try {
                    f.second(() -> {
                        System.out.print("2");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread t3 = new Thread(() -> {
                try {
                    f.third(() -> {
                        System.out.print("3");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t3.start();
            t2.start();
            t1.start();
            System.out.println();
        }
    }
}
