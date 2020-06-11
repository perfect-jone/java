package com.atjone.java.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 从内存中写出数据到硬盘中
public class MyFileWriter {
    public static void main(String[] args) throws IOException {

        // 1.创建FileWriter的对象，用于数据的写出到硬盘
        // true表示当文件存在时，以追加的方式写入，false表示覆盖原文件
        FileWriter fw = new FileWriter(new File("hello.txt"),true);

        // 2.写出操作
        fw.write("I have a dream!\n");
        fw.write("You are my sunshine!\n");

        // 3.关闭流资源
        fw.close();
    }
}
