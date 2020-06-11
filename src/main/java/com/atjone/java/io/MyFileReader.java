package com.atjone.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// 从硬盘中读数据到内存中
public class MyFileReader {
    public static void main(String[] args) {

        FileReader fr = null;
        int data = 0;
        try {

            // 1.创建FileReader对象，用于读入数据到内存中
            fr = new FileReader(new File("hello.txt"));

            // 2.读入操作
            // 每次读取一个字符，如果达到文件末尾，则返回-1
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    // 3.流资源的关闭
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
