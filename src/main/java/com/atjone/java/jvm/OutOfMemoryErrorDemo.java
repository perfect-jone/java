package com.atjone.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jone
 * @create 2020-06-18 13:55
 */
public class OutOfMemoryErrorDemo {
    public static void main(String[] args) {
        try {
            while (true) {

                // 死循环创建对象会导致java.lang.OutOfMemoryError
                List arrayList = new ArrayList<>(Integer.MAX_VALUE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


