package com.atjone.java.thread;


class Ticket1 //资源类 = 实例变量+实例方法
{
    private int ticket = 100;

    public void sale() {
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (ticket--) + "\t 还剩下： " + ticket);
        }
    }

}

/**
 * 同步代码块：
 * 1.操作共享数据的代码块即为需要同步的代码块
 * 2.共享数据：多线程共同操作的变量
 * 3.synchronized(同步监视器)：同步监视器俗称锁，任何一个类的对象都可以充当锁，但多线程必须要共用一把锁
 *
 * 注意：如果资源类继承了Thread类，在mian方法中创建任何一个类的对象时要加static保证唯一性
 */
public class SaleTicketSynchronized {
    public static void main(String[] args) { //主线程，一切程序的入口
        Ticket1 ticket1 = new Ticket1();

        new Thread(() -> {
            synchronized (ticket1) {
                for (int i = 1; i <= 200; i++) {
                    ticket1.sale();
                }
            }
        }, "A").start();
        new Thread(() -> {
            synchronized (ticket1) {
                for (int i = 1; i <= 200; i++) {
                    ticket1.sale();
                }
            }
        }, "B").start();
        new Thread(() -> {
            synchronized (ticket1) {
                for (int i = 1; i <= 200; i++) {
                    ticket1.sale();
                }
            }
        }, "C").start();

    }
}