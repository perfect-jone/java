package com.atjone.java;


import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("pating");
        list.forEach(System.out::println);
    }
}
