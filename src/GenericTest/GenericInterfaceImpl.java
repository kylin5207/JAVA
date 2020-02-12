package GenericTest;

//含有泛型接口的实现类

public class GenericInterfaceImpl implements GenericInterface<String>{


    @Override
    public void method(String s) {
        System.out.println(s);
    }
}
