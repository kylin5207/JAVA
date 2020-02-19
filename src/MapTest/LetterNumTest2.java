package MapTest;


//计算一个字符串中每个字符出现次数（第二种方法）。


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LetterNumTest2 {
    public static void main(String[] args) {

        //1. 获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String string = sc.next();

        //2. 使用toCharArray()得到String对象中的各个字符
        char[] letters = string.toCharArray();

        //3. 创建一个map对象
        HashMap<Character, Integer> map = new HashMap<>();

        //4. 遍历字符数组，将其中的元素作为key加入map，对应的value值为其出现的次数
        for (char letter : letters) {
            if(map.containsKey(letter)) {
                Integer num = map.get(letter);
                num++;
                map.put(letter, num);
            }
            else {
                map.put(letter, 1);
            }
        }

        //5. 输出map
        System.out.println(map);
    }
}
