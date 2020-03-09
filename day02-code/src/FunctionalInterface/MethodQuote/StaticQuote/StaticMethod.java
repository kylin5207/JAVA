package FunctionalInterface.MethodQuote.StaticQuote;

/*
     通过类名称引用静态方法
        前提：类存在，方法也存在
 */
public class StaticMethod {
    public static void main(String[] args) {
        int n = -99;

        System.out.println(calculateabs(n, Math::abs));

    }

    public static int calculateabs(int n, Calculable c) {
        return c.calculate(n);
    }
}
