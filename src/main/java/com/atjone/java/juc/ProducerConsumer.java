package com.atjone.java.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jone
 * @create 2020-06-17 14:26
 * <p>
 * 生产者消费者:
 * 1.线程操作资源类
 * 2.判断、干活、通知
 * 3.多线程虚假唤醒：判断必须用while，不能用if
 *
 * synchronized(wait/notify/notifyALL) 和 ReentrantLock(condition.awit/condition.signal/condition.signalAll)
 *
 */
public class ProducerConsumer {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        // 线程A减少温度
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    // TimeUnit.MILLISECONDS.sleep(100);
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程A").start();

        // 线程B增加温度
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程B").start();

        // 线程C减少温度
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程C").start();

        // 线程D增加温度
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    airCondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "线程D").start();
    }
}

class AirCondition {
    private int number = 0;

    // ReentrantLock（可重入递归非公平锁）默认为false，表示非公平锁。
    Lock lock = new ReentrantLock(false);
    Condition condition = lock.newCondition();
    

/*    public synchronized void increment() throws Exception {
        // 判断
        while (number != 0) {
            wait();
        }

        // 干活
        number++;
        System.out.println(Thread.currentThread().getName() + ":" + number);

        // 通知
        notifyAll();
    }

    public synchronized void decrement() throws Exception {
        while (number == 0) {
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + ":" + number);
        notifyAll();
    }*/

    public void increment() {
        lock.lock();
        try {
            // 判断
            while (number != 0) {
                condition.await(); // wait()
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + ":" + number);

            // 通知
            condition.signalAll(); // notifyAll()
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void decrement() {

        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + ":" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}