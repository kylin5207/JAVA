package ExceptionTest.CustomException;

import java.util.Scanner;

/*  练习题：我们模拟注册操作，如果用户名已存在，则抛出异常并提示:亲，该用户名已经被注册

   分析：
        1。 使用数组保存已经注册过的用户名
        2。 使用Scanner获取用户输入的注册的用户名
        3。 定义一个方法，对用户输入的注册用户名进行判断



*/
public class Test {

    static String[] usernames = {"kylin", "smq", "伊二狗"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入注册用户名：");
        String name = sc.next();

        checkedUsername(name);


    }

    public static void checkedUsername(String name) {
        for (int i = 0; i < usernames.length; i++) {
            if(usernames[i].equals(name) == true){
                try {
                    throw new RegisterException("亲，该用户名已经被注册");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return; //结束方法
                }
            }
        }
        System.out.println("注册成功");
    }
}
