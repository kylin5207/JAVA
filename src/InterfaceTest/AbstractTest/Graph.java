package InterfaceTest.AbstractTest;
//接口中的抽象方法的关键字，固定为public abstract,如果省略，也是默认如此
public interface Graph {

    //1. 标准写法
    public abstract void method1();

    //2. 这也是抽象方法
    abstract void method2();

    //3. 省略，默认为public abstract
    void method3();


}
