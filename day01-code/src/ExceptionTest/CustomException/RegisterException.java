package ExceptionTest.CustomException;
/*
    自定义异常类：
        用于个性化需求而设计的异常类
    格式：
        public class XXXException extend  Exception{

        }

    提示：
        1。 自定义异常类一般都以Exception结尾，说明该类是一个异常类
        2。 必须继承一种异常（Exception或者RuntimeException）


 */

public class RegisterException extends Exception{
    public RegisterException() {
    }

    public RegisterException(String message) {
        //添加带异常信息的构造方法
        super(message);
    }
}
