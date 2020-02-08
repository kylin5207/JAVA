package ClassTest.InnerClassTest;

public class SameVariable {
    public static void main(String[] args) {
        OuterClass.InnerClass test = new OuterClass().new InnerClass();
        test.method();
    }
}
