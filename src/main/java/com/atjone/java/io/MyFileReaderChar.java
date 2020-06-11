package com.atjone.java.io;

import java.lang.String;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// 从硬盘中读数据到内存中
public class MyFileReaderChar {
    public static void main(String[] args) {

        FileReader fr = null;
        try {
            // 1.创建FileReader对象，用于读入数据到内存中
            fr = new FileReader(new File("hello.txt"));

            // 2.读入操作
            // 每次读取cbuf数组中的字符个数，如果达到文件末尾，则返回-1
            int len;
            // 创建一个字符数组，表示每次读入1024个字符
            char[] cbuf = new char[1024];
            while ((len = fr.read(cbuf)) != -1) {
                /**
                 *  错误的写法
                 *  for (int i = 0; i < cbuf.length; i++) {
                 *      System.out.print(cbuf[i]);
                 *  }
                 *
                 */
                // cbuf数组中放几个就读几个
                // 方式一
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                // 方式二
                //System.out.print(new String(cbuf,0,len));
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
