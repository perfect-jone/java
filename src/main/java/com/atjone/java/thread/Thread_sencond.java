package com.atjone.java.thread;

/**
 * @author Jone
 * @description ：四种创建多线程方式之第二种：实现Runnable接口，实现run方法,把实现实现Runnable接口的类的对象传入Thread类的构造器中
 * @create 2020-06-15 10:54
 */
public class Thread_sencond {
    public static void main(String[] args) {
        MyThread2 mythread = new MyThread2();

        Thread t1 = new Thread(mythread);
        t1.setName("线程1");
        t1.start();

        Thread t2 = new Thread(mythread);
        t2.setName("线程2");
        t2.start();


    }
}

class MyThread2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}