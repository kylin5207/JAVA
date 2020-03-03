package ClassTest.AnimalTest;

public class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼鱼🐟");
    }

    public void catchMouse(){
        System.out.println("抓老鼠🐭");
    }
}
