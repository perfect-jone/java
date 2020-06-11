package com.atjone.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用FileReader和FileWriter两个字符流来实现文本文件的复制
 */
public class FileReader_FileWriter {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            // 1.创建File对象，指明读入和写出文件的位置
            File srcFile = new File("srcFile.txt");
            File destFile = new File("destFile.txt");

            // 2.创建输入流和输出流对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile, false);

            // 3.数据的读入和写出操作
            char[] cbuf = new char[1024];
            int len; // 记录每次读入到cbuf数组中字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.关闭流资源
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
