package com.atjone.java.jvm;

/**
 * @author Jone
 * @create 2020-06-18 13:02
 */
public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        System.out.println("main");
        test();
    }

    // 递归调用会导致Exception in thread "main" java.lang.StackOverflowError
    public static void test() {
        test();
    }
}
