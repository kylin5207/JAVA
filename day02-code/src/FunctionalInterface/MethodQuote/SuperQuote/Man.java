package FunctionalInterface.MethodQuote.SuperQuote;

/*
    使用父类的方法实现方法引用：
        super::成员方法

    使用自己的方法实现方法引用：
        this代表当前对象，如果需要引用的方法就是当前类中的成员方法，那么可以使用“this::成员方法”的格式来使用方 法引用。
 */
public class Man extends Human {

    @Override
    public void say() {
        System.out.println("Hello, Man类成员方法");
    }

    public void method(Greetable g) {
        g.greet();
    }

    public void show() {
//        method(()-> {
//            Human human = new Human();
//            human.say();
//        });

//        //因为有子父类关系，所以可以使用super代表父类（lambda表达式）
//        method(() -> super.say());

        //使用方法引用
        method(super::say);
    }

    public void show2() {
        method(this::say);
    }

    public static void main(String[] args) {
        new Man().show2();
    }
}
