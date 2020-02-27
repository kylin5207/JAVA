package LambdaTest;
/*
    给定一个厨子 Cook 接口，内含唯一的抽象方法makeFood ，且无参数、无返回值
 */
interface Cook {
    void makeFood();
}
public class CookTest {
    public static void main(String[] args) {

        //使用匿名类实现
        new Cook(){
            public void makeFood(){
                System.out.println("厨子做饭(匿名类实现)");
            }
        }.makeFood();


        //使用lambda表达式
        //小括号代表Cook接口的makeFood()的参数为空，大括号表示makeFood()的方法体
        invokecook(() -> {
            System.out.println("厨子做饭(lambda表达式实现)");
        });
    }

    public static void invokecook(Cook cook) {
        cook.makeFood();
    }
}
