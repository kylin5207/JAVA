package OtherTest.VariableParameters;

/*
    可变参数
    使用前提：方法的参数列表数据类型已经确定，但是参数个数不确定
    使用方法：定义方法时使用
    注意事项；
        1.一个方法的参数列表，只能有一个可变参数
        2.如果方法的参数有多个，那么可变参数必须写在方法的参数列表的末尾
*/

public class ParametersTest {
    public static void main(String[] args) {

        int num = sum(10,100);
        System.out.println("sum = " + num);

    }

    public static int sum(int ... a) {
    //计算整数之和，已知参数类型为int，个数不知，使用可变参数定义行参
        System.out.println("可变参数的底层是一个数组，数组长度：" + a.length);

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }
}
