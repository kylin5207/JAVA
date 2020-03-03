package InterfaceTest.DefaultTest;

public class Cat implements Live {


    @Override
    public void eat() {
        System.out.println("吃鱼！");
    }

    public void catchMouse()
    {
        System.out.println("抓老鼠");
    }

}
