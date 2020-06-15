package com.atjone.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建多线程的第三种方式：
 * 1.实现Callable接口，重写call方法
 * 2.创建实现Callable接口实现类的对象
 * 3.将实现Callable接口实现类的对象作为参数传入到FutureTask类的构造器中
 * 4.将FutureTask对象作为参数传入到Thread类的构造器中，调用start方法
 *
 * Callable接口比Runnable接口强大：
 * 1.call方法有返回值
 * 2.call方法可以抛出异常，并且可以被外面的操作捕获
 * 3.Callable接口支持泛型
 */
public class Thread_third {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        FutureTask futureTask = new FutureTask(myThread3);
        new Thread(futureTask).start();
        try {
            // get方法返回值即为call方法的返回值
            Object sum = futureTask.get();
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread3 implements Callable<Integer> {
    int sum = 0;

    @Override
    public Integer call() throws Exception {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}
