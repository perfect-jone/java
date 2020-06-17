package com.atjone.java.juc;

import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Consumer;

/**
 * @author Jone
 * @create 2020-06-16 21:00
 *
 * 1.ArrayList线程不安全：java.util.ConcurrentModificationException
 * 2.解决方案：
 *      2.1 new Vector<>()
 *      2.2 Collections.synchronizedList(new ArrayList<>())
 *      2.3 new CopyOnWriteArrayList<String>()
 */
public class NotSafe01 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
/*        list.add("a");

        // PrintStream继承FilterOutputStream
        PrintStream printStream = System.out;

        //  “函数式接口 变量名 = 类实例::方法名” 的方式对该方法进行引用
        Consumer consumer = printStream::println;
        list.forEach(consumer);*/

        // java.util.ConcurrentModificationException


        listNotSafe();

        setNotSafe();

        mapNotSafe();
    }

    public static void mapNotSafe() {
        Map<String,String> map1 = new HashMap<String,String>();
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i <30 ; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+":"+map);
            }, String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
        Set<String> set1 = new HashSet<String>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i <30 ; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+":"+set);
            }, String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
        List<String> list1 = new Vector<>();
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i <30 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName()+":"+list);
            }, String.valueOf(i)).start();
        }
    }
}
