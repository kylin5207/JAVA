package Red;

import java.util.ArrayList;
import java.util.Arrays;

public class NormalMode implements OpenMode{

    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount; //均值
        int mod = totalMoney % totalCount; //余数

        for (int i = 0; i < totalCount - 1 ; i++) {
            list.add(avg);
        }

        //把零头放在最后一个红包当中
        list.add(avg + mod);

        return list;
    }
}
