package ExceptionTest.FatherSonException;

/*
    1. 如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同的异常或者是父类异常的子类或者不抛出异常。
    2. 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
    父类方法什么样，子类方法就怎样
*/

import java.io.IOException;

public class Son extends Father {
    public Son() {
    }

    public Son(int[] array) {
        super(array);
    }

    @Override
    public int getIndex(int index) {
        System.out.println("子类中的getArray");
        int num = super.getIndex(index);
        return num;
    }

    @Override
    public void method() {
        System.out.println();

    }
}
