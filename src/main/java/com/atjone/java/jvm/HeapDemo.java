package com.atjone.java.jvm;

/**
 * @author Jone
 * @create 2020-06-18 22:03
 */
public class HeapDemo {
    public static void main(String[] args) {

        // 获取计算机核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 获取堆内存最大可分配内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("-Xmx:maxMemory" + ":" + (maxMemory / (double) 1024 / 1024) + "MB");

        // 获取堆内存初始大小
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xms:totalMemory" + ":" + (totalMemory / (double) 1024 / 1024) + "MB");

        // 获取堆内存空闲内存
        long freeMemory = Runtime.getRuntime().freeMemory();
        //System.out.println(freeMemory+"字节\t"+freeMemory/1024/1024+"MB");

    }
}
