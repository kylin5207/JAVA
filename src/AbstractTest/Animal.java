package AbstractTest;

public abstract class Animal {
    public Animal()
    {
        System.out.println("父类构造方法执行");
    }

    public abstract void eat();
}
