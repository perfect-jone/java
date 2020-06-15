package com.atjone.java.thread;


class Ticket2 //资源类 = 实例变量+实例方法
{
    private int ticket = 100;

    public synchronized void sale() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (ticket--) + "\t 还剩下： " + ticket);
        }
    }

}

/**
 * 同步代码块：
 * 1.操作共享数据的方法即为需要同步的方法
 * 2.共享数据：多线程共同操作的变量
 * 3.synchronized(同步监视器)：同步监视器俗称锁，任何一个类的对象都可以充当锁，但多线程必须要共用一把锁
 * <p>
 * 注意：如果资源类继承了Thread类，在mian方法中创建任何一个类的对象时要加static保证唯一性
 */
public class SaleTicketSynchronizedMethod {
    public static void main(String[] args) { //主线程，一切程序的入口
        Ticket2 ticket2 = new Ticket2();

        new Thread(() -> { for (int i = 1; i <= 200; i++) ticket2.sale(); }, "A").start();
        new Thread(() -> { for (int i = 1; i <= 200; i++) ticket2.sale(); }, "B").start();
        new Thread(() -> { for (int i = 1; i <= 200; i++) ticket2.sale(); }, "C").start();

    }
}