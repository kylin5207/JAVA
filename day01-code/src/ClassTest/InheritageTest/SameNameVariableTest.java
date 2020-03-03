package ClassTest.InheritageTest;

//用于查看父类和子类相同的成员变量的取值
public class SameNameVariableTest {
    public static void main(String[] args) {

        SonClass son = new SonClass();
        son.printBasenum();
        son.printNum();
    }
}
