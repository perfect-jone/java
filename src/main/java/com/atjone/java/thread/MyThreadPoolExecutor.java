package com.atjone.java.thread;

import sun.text.resources.cldr.ia.FormatData_ia;

import java.util.concurrent.*;

/**
 * @author Jone
 * @create 2020-06-18 17:32
 */
public class MyThreadPoolExecutor {
    public static void main(String[] args) {

        // 创建线程池
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                2, // 核心线程，即常用的
                5, // 线程池里最大线程数
                1L, // 多余的空闲线程在终止之前等待新任务的最长时间
                TimeUnit.SECONDS, // keepAliveTime的时间单位
                new LinkedBlockingDeque<Runnable>(3), //队列的大小，超出最大线程数承受的任务就去队列等待
                Executors.defaultThreadFactory(), // 默认值，通常不变，如果任务超出了队列的大小，则开启拒绝策略
                /**
                 *  四种拒绝策略：
                 *  1.AbortPolicy（默认）：直接抛出RejectedException
                 *  2.CallerRunsPolicy：不会抛弃任务也不会抛出异常，而是回退给调用者
                 *  3.DiscardOldestPolicy：丢弃等待最久的任务。
                 *  4.DiscardPolicy：直接丢弃被拒绝的任务，不做任何处理。
                 */
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            //模拟10个用户去银行办理业务
            for (int i = 1; i <= 15; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t"+"办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //关闭线程池
            threadPoolExecutor.shutdown();
        }
    }
}
