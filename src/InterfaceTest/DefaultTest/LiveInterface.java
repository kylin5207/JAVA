package InterfaceTest.DefaultTest;

public class LiveInterface {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.eat();

        Bird bird = new Bird();
        bird.eat();
        bird.fly();
    }
}
