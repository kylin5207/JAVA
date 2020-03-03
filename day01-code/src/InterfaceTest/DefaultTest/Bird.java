package InterfaceTest.DefaultTest;

public class Bird implements Live {

    @Override
    public void eat() {
        System.out.println("吃虫子");
    }

    @Override
    public void fly() {
        System.out.println("我要飞得更高");
    }
}
