package com.atjone.java.io;

import java.io.*;

public class BufferedReader_BufferedWriter {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            // 1.创建输入流和输出流
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello3.txt")));

            // 2.数据的读入和写出
            /**
             *  方式一
             *  char[] buf = new char[1024];
             *  int len;
             *  while ((len = br.read(buf)) != -1) {
             *      bw.write(buf, 0, len);
             *  }
             */

            // 方式二
            String data;
            while ((data = br.readLine()) != null) {
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭资源
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
