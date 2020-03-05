package FunctionalInterface.SupplierTest;

/*
    使用 Supplier 接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
    提示:接口的泛型请使用java.lang.Integer类
 */

import java.util.function.Supplier;

public class GetMax {
    public static void main(String[] args) {
        int[] arrays = {2, 99, 10, 101, 200, 188};

        int max = getMax(() -> {
            int temp = arrays[0];
            for (int i = 1; i < arrays.length; i++) {
                if (arrays[i] > temp) {
                    temp = arrays[i];
                }
            }
            return temp;
        });

        System.out.println("最大值：" + max);
    }

    public static int getMax(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
