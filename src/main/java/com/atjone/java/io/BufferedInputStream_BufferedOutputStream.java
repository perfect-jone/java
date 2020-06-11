package com.atjone.java.io;

import java.io.*;

public class BufferedInputStream_BufferedOutputStream {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            // 1.创建输入流和输出流
            bis = new BufferedInputStream(new FileInputStream(new File("tree.png")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("tree1.png")));

            // 2.数据的读入和写出
            byte[] buf = new byte[1024];
            int len;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭资源
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
