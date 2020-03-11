package AnnotationTest.AnnotationDemo;

public class Calculator {

    @Check
    public void add(int a, int b) {
        System.out.println(a + " + " + b + " = "+ (a+b));
    }

    @Check
    public void sub(int a, int b) {
        System.out.println(a + " - " + b + " = "+ (a-b));
    }

    @Check
    public void mul(int a, int b) {
        System.out.println(a + " * " + b + " = "+ (a*b));
    }

    @Check
    public void div(int a, int b) {
        System.out.println(a + " / " + b + " = "+ (a/b));
    }

    void show() {
        System.out.println("Kylin的计算器");
    }
}
