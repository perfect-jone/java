package com.atjone.java.io;

import java.io.*;

public class Encryption {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\jone\\Desktop\\first.avi"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\jone\\Desktop\\first_encryption.avi"));

        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1){
            for (int i = 0; i < len; i++) {
                buf[i] = (byte) (buf[i] ^ 2);
            }
            bos.write(buf,0,len);
        }

        bos.close();
        bis.close();
    }
}
