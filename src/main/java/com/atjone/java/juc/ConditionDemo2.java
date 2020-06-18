package com.atjone.java.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jone
 * @create 2020-06-17 21:25
 * @description 多线程之间按照顺序调用：A -> B -> C
 * 三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次，依照此种方法循环打印10次
 */
public class ConditionDemo2 {
    public static void main(String[] args) {
        ShareData2 shareData = new ShareData2();
        new Thread(() -> shareData.printA(), "A").start();
        new Thread(() -> shareData.printB(), "B").start();
        new Thread(() -> shareData.printC(), "C").start();
    }
}

// 资源类
class ShareData2 {

    // 设置标志位，0表示A，1表示B，2表示C
    private int state = 0;
    private Lock lock = new ReentrantLock();
    private Condition A = lock.newCondition();
    private Condition B = lock.newCondition();
    private Condition C = lock.newCondition();

    public void printA() {
        print(5, 0, A, B);
    }

    public void printB() {
        print(10, 1, B, C);
    }

    public void printC() {
        print(15, 2, C, A);
    }

    /**
     * @param count            打印多少次
     * @param currentState     当前标志位
     * @param currentCondition 当前condition
     * @param nextCondition    下一个condition
     */
    public void print(int count, int currentState, Condition currentCondition, Condition nextCondition) {
        for (int i = 1; i <= 10; ) {
            lock.lock();
            try {
                // 1.判断
                while (state % 3 != currentState) {
                    // 当前currentCondition等待
                    currentCondition.await();
                }
                // 2.打印
                for (int j = 1; j <= count; j++) {
                    System.out.println(Thread.currentThread().getName() + "\t" + j);
                }
                // 3.更改标志位
                state++;
                i++;
                // 4.通知下一个Condition
                nextCondition.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
