package ClassTest.InnerClassTest;

public class OuterClass {
    int num = 1000;

    public class InnerClass{
        int num = 100;

        public void method()
        {
            int num = 10;
            System.out.println(num);

//            使用this关键字，调用内部类的num变量
            System.out.println(this.num);

//            使用父类.this关键字，调用外部类的num变量
            System.out.println(OuterClass.this.num);
        }
    }
}
