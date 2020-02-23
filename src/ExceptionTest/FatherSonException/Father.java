package ExceptionTest.FatherSonException;
/*
    父类异常什么样，子类异常就什么样
 */
public class Father {
    int[] array;

    public Father() {
    }

    public Father(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getIndex(int index) throws NullPointerException, ArrayIndexOutOfBoundsException{
        if(array == null) {
            throw new NullPointerException("当前数组为空！");
        }
        else if(index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("索引越界");
        }
        return array[index];
    }

    public void method() {
        System.out.println("父类方法无异常");
    }

}
