package FunctionalInterface.LoggerTest;

/*
    日志
        根据日志的级别，显示日志信息的方法
        注意：
            存在性能浪费问题：
                论级别是否满足要求，作为showLog()方法的第二个参数，三个字符串一定会首先被拼接并传入方法内，然后才会进行级别判断。
                如果级别不符合要求，那么字符串的拼接操作就白做了，存在性能浪费。

 */
public class Logger {
    public static void main(String[] args) {
        //主方法中有三个日志信息
        String msg1 = "message1";
        String msg2 = "message2";
        String msg3 = "message3";

        //调用showLog
        showLog(1, msg1+msg2+msg3);
    }

    public static void showLog(int level, String message) {
    //对日志的等级进行判断，级别1，输出日志信息
        if(level == 1) {
            System.out.println(message);
        }
    }
}
