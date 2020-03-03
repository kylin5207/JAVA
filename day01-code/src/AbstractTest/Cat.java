package AbstractTest;

public class Cat extends Animal {
    public Cat()
    {
        System.out.println("子类构造方法执行");
    }

    @Override
    public void eat() {
        System.out.println("吃鱼鱼咯");
    }
}
