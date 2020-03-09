package FunctionalInterface.MethodQuote.ConstructionQuote;

/*
    定义一个创建Person对象的函数式接口
 */
@FunctionalInterface
public interface PersonBuilder {
    //定义一个根据传递的姓名，创建Person对象的方法
    Person createPerson(String name);
}
