package com.atjone.java.thread;

import com.sun.org.apache.xpath.internal.functions.FuncTrue;

import java.util.concurrent.*;

/**
 * @author Jone
 * @create 2020-06-16 9:50
 * <p>
 * 创建多线程的第四种方式：使用线程池
 */
public class Thread_forth {
    public static void main(String[] args) {

        // 创建线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
 /*       service1.setCorePoolSize();
        service1.setKeepAliveTime();
        service1.setMaximumPoolSize();
        service1.setRejectedExecutionHandler();
        service1.setThreadFactory();*/

        // execute适用于Runnable接口
        service.execute(new MyThread04());

        // submit适用于Callable接口
        // FutureTask类的构造器中可以传Runnable接口和Callable接口
        FutureTask futureTask = new FutureTask(new MyThread05());

        //FutureTask类实现了Runnable接口
        service.submit(futureTask);

        try {
            Object sum = futureTask.get();
            System.out.println("sum=" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭线程池
        service.shutdown();
    }
}

class MyThread04 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class MyThread05 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
        return sum;
    }
}