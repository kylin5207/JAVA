package StreamTest.Introduction;

import java.util.ArrayList;
import java.util.List;

/*
    传统对集合处理对方式

 */
public class NormalMethod {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("kylin");
        list.add("Krush");
        list.add("Ysl");
        list.add("Sqi");
        list.add("Kim");

        //对元素进行遍历，将姓名以k开头对放在一个新集合中
        List<String> k_list = new ArrayList<>();
        for (String s : list) {
            if(s.toLowerCase().startsWith("k")) {
                k_list.add(s);
            }
        }
        System.out.println("以k开头的姓名：" + k_list);

        //对姓名为k开头对元素进行遍历，将长度为3的姓名放在一个集合
        List<String> length_3 = new ArrayList<>();
        for (String s : k_list) {
            if(s.length() == 3) {
                length_3.add(s);
            }
        }
        System.out.println("以k开头且姓名长度为3的元素列表：" + length_3);
    }
}
