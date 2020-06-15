package com.atjone.java.thread;

import java.util.concurrent.locks.ReentrantLock;

class Ticket //资源类 = 实例变量+实例方法
{
    private int ticket = 30;

    //Lock是接口，ReentrantLock（可释放锁）是Lock的实现类
    private ReentrantLock lock = new ReentrantLock(true);

    public void sale() {
        lock.lock();
        try {
            Thread.sleep(100);
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (ticket--) + "\t 还剩下： " + ticket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @auther Jone
 * <p>
 * 题目：三个售票员   卖出   30张票
 * 笔记：如何编写企业级的多线程代码
 * 固定的编程套路+模板是什么？
 * <p>
 * 在高内聚低耦合的前提下，线程        操作      资源类
 */
public class SaleTicketDemo01 {
    public static void main(String[] args)//主线程，一切程序的入口
    {
        Ticket ticket = new Ticket();


        // 特殊符号快捷入口v1-v9 ：  v1：标点符号     v6:希腊/拉丁文
        // λ表达式设置： File -> Project Structure -> Modules -> Language Level
        // java8设置： File -> Project Structure 和  File -> Settings -> Build,Execution,Deployment -> Complier -> Java Complier
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) ticket.sale();
        }, "C").start();


    }
}