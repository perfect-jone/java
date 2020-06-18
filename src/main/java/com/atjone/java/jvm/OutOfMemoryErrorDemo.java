package com.atjone.java.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Jone
 * @create 2020-06-18 13:55
 */
public class OutOfMemoryErrorDemo {
    public static void main(String[] args) {

        String str = "www.atguigu.com";
/*        while (true) {
            // 死循环创建对象会导致java.lang.OutOfMemoryError: Java heap space
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
        }*/
        byte[] bytes = new byte[10 * 1024 *1024];
    }
}


