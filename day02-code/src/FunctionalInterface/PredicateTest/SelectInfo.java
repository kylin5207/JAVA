package FunctionalInterface.PredicateTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
    数组当中有多条“姓名+性别”的信息如下，请通过 Predicate 接口的拼装将符合要求的字符串筛选到集合ArrayList中，需要同时满足两个条件:
    1. 必须为女生;
    2. 姓名为4个字。
 */
public class SelectInfo {
    public static void main(String[] args) {
        String[] arrays = {"帅琦,女" , "阿细世林,男", "迪丽热巴,女"};

        ArrayList<String> list = filter(arrays, s -> s.split(",")[1].equals("女"), s -> s.split(",")[0].length()==4);
        System.out.println(list);
    }

    public static ArrayList<String> filter(String[] arrays, Predicate<String> sexPredicate, Predicate<String> namePredicate) {
        boolean answer;
        ArrayList<String> list = new ArrayList<>();
        for (String array : arrays) {
            answer = sexPredicate.and(namePredicate).test(array);
            if(answer) {
                list.add(array);
            }
        }
        return list;
    }

}
