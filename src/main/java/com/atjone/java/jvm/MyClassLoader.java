package com.atjone.java.jvm;

/**
 * @author Jone
 * @create 2020-06-18 9:00
 */
public class MyClassLoader {
    public static void main(String[] args) {
        Object object = new Object();
        MyClassLoader myClassLoader = new MyClassLoader();

        System.out.println(object.getClass().getClassLoader());
//        System.out.println(object.getClass().getClassLoader().getParent());
//        System.out.println(object.getClass().getClassLoader().getParent().getParent());

        /**
         * 三个类加载器：
         * 1.BootstrapClassLoader(启动类加载器)  C++  $JAVA_HOME/jre/lib/rt.jar
         * 2.ExtensionClassLoader(扩展类加载器)  Java $JAVA_HOME/jre/lib/ext/*.jar
         * 3.AppClassLoader(应用程序类加载器)         $CLASSPATH
         */
        System.out.println(myClassLoader.getClass().getClassLoader().getParent().getParent());
        System.out.println(myClassLoader.getClass().getClassLoader().getParent());
        System.out.println(myClassLoader.getClass().getClassLoader());

        Thread thread = new Thread();
        thread.start();

    }
}
