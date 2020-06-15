package com.atjone.java.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Jone
 * @description
 * @create 2020-06-15 15:17
 */
public class Wait_Notify {
    public static void main(String[] args) {
        Number number = new Number();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.print();
            }
        }, "线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number.print();
            }
        }, "线程2").start();
    }
}

class Number {
    private int number = 1;

    public void print() {
        while (true) {

            synchronized (this) {

                // 调用notify方法使阻塞状态的线程进入就绪状态
                notify();
                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                }
                try {
                    // 调用wait方法的线程进入阻塞状态
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
