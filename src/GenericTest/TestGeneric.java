package GenericTest;

public class TestGeneric {
    public static void main(String[] args) {

//        如果不写泛型的具体类型，默认为object类型
        System.out.println("-------未指定具体的泛型，默认为Object类型-----");
        GenericDemo test1 = new GenericDemo();
        test1.setValue(12);
        Object o1 = test1.getValue();
        System.out.println(o1);

//        指定泛型为String类型
        System.out.println("------指定具体的对象类型为String类型--------");
        GenericDemo<String> test2 = new GenericDemo<>();

//        test2.setValue(1);此时，设定其他类型的值会报错

        test2.setValue("Kylin");
        System.out.println(test2.getValue());

    }
}
