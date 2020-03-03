package ClassTest.AnimalTest;

public class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }

    public void cathThief(){
        System.out.println("抓小偷！");
    }
}
