package Red;

import java.util.ArrayList;
import java.util.Random;

public class RandomMode implements OpenMode{
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {

        ArrayList<Integer> list = new ArrayList<>();

        /*随机分配，有可能多，有可能少。
        最少一分钱，最多不超过"剩下金额平均数的两倍*/

//        范围公式：
//        1 + Random.nextInt(leftMoney / leftCount * 2)

        Random rand = new Random();

        int leftMoney = totalMoney;
        int leftCount = totalCount;

        //发红包，随机发钱n-1个，最后一个不需要发钱
        for (int i = 0; i < totalCount-1; i++) {
            //生成随机金额
            int money = rand.nextInt(leftMoney / leftCount * 2) + 1;
            list.add(money);
            leftMoney -= money;
            leftCount--;
        }

        //最后一个红包，直接塞入
        list.add(leftMoney);

        return list;
    }
}
