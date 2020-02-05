package ArrayListTest;

//生成6个1~33之间的随机整数,添加到集合,并遍历


import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList {
    public static void main(String[] args) {

        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 6 ; i++) {
            list.add(rand.nextInt(33)+1);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
