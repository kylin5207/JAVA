package ClassTest.InheritageTest;
//父类

public class BaseClass {
    int basenum = 1;
    int num = 20;

    public void printBasenum() {
        System.out.println("父类的成员变量basenum的值是："+basenum);
    }

    public void printNum()
    {
        System.out.println("父类printNum被调用，num="+num);
    }

}
