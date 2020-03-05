package FunctionalInterface.LoggerTest;
/*
    使用lambda表达式优化日志案例：
        延迟加载

    优点：
        1. 只有当级别满足要求的时候，才会进行三个字符串的拼接;否则三个字符串将不会进行拼接
        2. 不存在性能浪费
 */

public class LambdaLogger {
    public static void main(String[] args) {
        //主方法中有三个日志信息
        String msg1 = "message1";
        String msg2 = "message2";
        String msg3 = "message3";

        showLog(1, () -> msg1 + msg2 + msg3);
    }

    public static void showLog(int level, MessageBuilder mb) {
        if(level == 1) {
            System.out.println(mb.buildMessage());
        }
    }


}
