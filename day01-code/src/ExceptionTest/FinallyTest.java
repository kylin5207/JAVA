package ExceptionTest;

//如果finally中出现return语句，永远返回的是finally语句中的相应值，这种情况应该避免

public class FinallyTest {
    public static void main(String[] args) {

        int a = getA();
        System.out.println(a); //输出的是finally中的a值

    }

    public static int getA() {
        int a;

        try {
            a = 10;
            return a;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            a = 100;
            return a; //避免这种情况发生
        }
    }

}
