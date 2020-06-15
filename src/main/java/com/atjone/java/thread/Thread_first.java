package com.atjone.java.thread;

/**
 * @author Jone
 * @description ：四种创建多线程方式之第一种：继承Thread类，实现该类的run方法
 * @create 2020-06-15 10:54
 */
public class Thread_first {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程1");
        t1.start();

        MyThread t2 = new MyThread();
        t2.setName("线程2");
        t2.start();

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
