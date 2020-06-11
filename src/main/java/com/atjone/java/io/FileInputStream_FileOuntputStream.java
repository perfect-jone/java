package com.atjone.java.io;

import java.io.*;

/**
 * 利用FileReader和FileWriter两个字符流来实现文本文件的复制
 */
public class FileInputStream_FileOuntputStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 1.创建File对象，指明读入和写出文件的位置
            File srcFile = new File("tree.png");
            File destFile = new File("tree1.png");

            // 2.创建输入流和输出流对象
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 3.数据的读入和写出操作
            byte[] buf = new byte[10 * 1024]; //缓冲区的大小为10K
            int len; // 记录每次读入到cbuf数组中字符的个数
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流资源
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
