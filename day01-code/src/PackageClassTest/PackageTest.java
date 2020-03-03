package PackageClassTest;

public class PackageTest {
    public static void main(String[] args) {
        int num = 100;

        System.out.println("------装箱与拆箱测试-------");
//        装箱：将基本数据类型转换为包装类对象
        Integer n = new Integer(num); // 方法上有横线，表示方法过时
        System.out.println("装箱后的num："+n);

//        使用Integer的静态方法valueOf（）进行装箱操作
        Integer m = Integer.valueOf(num);
        System.out.println("装箱后的num："+m);


//        拆箱：将包装类对象转换为基本数据类型的数据，使用Integer的成员对象intValue（）
        int num2 = n.intValue();
        System.out.println("拆箱后的数据："+num2);

        System.out.println("--------数据类型和字符串间的转换------");
//        基本类型-->字符串：基本数据类型的值+""  (工作中常用)
        String s = 99 + "";
        System.out.println("99的字符串形式："+s);
//        或者使用基本数据类型包装类的toString()方法
        String s2 = Integer.toString(99);
        System.out.println("字符串表示："+s2);

        int s_n = Integer.parseInt(s);
        System.out.println("字符串对应的int值是："+s_n);

    }
}
