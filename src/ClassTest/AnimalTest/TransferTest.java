package ClassTest.AnimalTest;

public class TransferTest {
    public static void main(String[] args) {

//        上转型对象animal1
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();

//        下转型对象animal2
//        Cat cat = (Cat) animal2; // 错误写法，编译成功，但出现ClassCastException异常

//        在进行下转型时，首先利用instance关键字进行类型判断
        if (animal1 instanceof Cat)
        {
            Cat cat = (Cat) animal1;
            cat.eat();
            cat.catchMouse();
        }

        else if (animal1 instanceof Dog)
        {
            Dog dog = (Dog) animal1;
            dog.eat();
            dog.cathThief();
        }
    }
}
