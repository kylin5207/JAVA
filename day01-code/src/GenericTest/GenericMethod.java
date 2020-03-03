package GenericTest;

//含有泛型的方法，在调用方法时确定泛型的数据类型：传递什么类型的参数，泛型就是什么类型

public class GenericMethod {

    public <E> void show(E value) {
        System.out.println(value);
    }
}
