package FunctionalInterface.ConsumerTest;

import java.util.function.Consumer;

/*
    格式化打印练习：
        下面的字符串数组当中存有多条信息，请按照格式“ 姓名:XX。性别:XX。”的格式将信息打印出来。
        要求：
        将打印姓名的动作作为第一个 Consumer 接口的Lambda实例，
        将打印性别的动作作为第二个 Consumer 接口的Lambda实例，
        将两个 Consumer 接口按照顺序“拼接”到一起。
 */
public class PrintInformation {
    public static void main(String[] args) {
        String[] arrays = {"Kylin,男", "丑林,女"};

        printInfo(arrays,
                s1-> System.out.print("name :" + s1.split(",")[0] + ", "),
                s2-> System.out.println("sex：" + s2.split(",")[1]));
    }

    public static void printInfo(String[] arrays, Consumer<String> nameConsumer, Consumer<String> sexConsumer) {
        for (String s : arrays) {
            nameConsumer.andThen(sexConsumer).accept(s);
        }
    }
}
