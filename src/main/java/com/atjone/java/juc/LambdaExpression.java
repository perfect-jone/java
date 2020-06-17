package com.atjone.java.juc;

/**
 * λ表达式：
 * 1.拷贝小括号，写死右箭头，落地大括号
 * 2.@FunctionInterface
 * 3.default
 * 4.static
 *
 * @author Jone
 * @create 2020-06-16 18:01
 */
public class LambdaExpression {
    public static void main(String[] args) {
/*        Cal cal = new Cal() {
            @Override
            public void print() {
                System.out.println("λ表达式");
            }
        };*/

        // λ表达式
/*    Cal cal =   () -> { System.out.println("λ表达式");};
    cal.print();*/

        Cal cal = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        int sum = cal.sum(4, 2);
        System.out.println(sum);

        int mul = cal.mul(4, 2);
        System.out.println(mul);

        int div = Cal.div(4, 2);
        System.out.println(div);

    }
}

@FunctionalInterface
        //函数式接口注解
interface Cal {

    //public void print();
    public int sum(int x, int y);

    public default int mul(int x, int y) {
        return x * y;
    }

    public static int div(int x, int y) {
        return x / y;
    }
}
