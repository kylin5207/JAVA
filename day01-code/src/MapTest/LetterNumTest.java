package MapTest;

//计算一个字符串中每个字符出现次数。

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LetterNumTest {
    public static void main(String[] args) {

        //1. 获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("输入字符串：");
        String string = sc.next();

        //2. 使用toCharArray()得到String对象中的各个字符，之后放入set集合中保证不重复
        char[] letters = string.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < letters.length; i++) {
            set.add(letters[i]);
        }
        System.out.println(set);


        //3. 利用map存储字符串中的字符，初始化哥哥字符的value为0
        HashMap<Character, Integer> map = new HashMap<>();

        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()){
            map.put(iterator.next(),0);
        }
        System.out.println("初始化后的map单词表：" + map);

        //4. 重新遍历string中的各个字符，将其对应的字符作为key，使得value+=1
        for (int i = 0; i < letters.length; i++) {
            if(map.containsKey(letters[i])){
                Integer num = map.get(letters[i]) + 1;
                map.put(letters[i], num);
            }
        }

        //5. 输出map
        System.out.println("字符串对应的字母出现个数：" + map);
    }
}
