package DateTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {

//        Calendar类是一个抽象类，只能通过getInstance()方法得到对象
        Calendar c = Calendar.getInstance();
//        使用get()获得相关的日期值
        PrintValues(c);

//        使用set()设置相关字段的值
        c.set(c.YEAR, 1996);
        System.out.println("-------修改YEAR字段后的Calendar相关数据-----");
        PrintValues(c);

//        可以使用set()的重载方法，同时设置年月日
        System.out.println("------同时修改年月日字段后的Calendar相关数据------");
        c.set(2014,9,20);
        PrintValues(c);

//        使用Calendar的getTime()将日期对象转换为Date对象
        Date date = c.getTime();
        showDate(date);
    }

    public static void PrintValues(Calendar c){
//        使用get()获得相关的日期值
        System.out.println("年份：" + c.get(c.YEAR));
//        注意：西方的月份从0开始
        System.out.println("月份：" + c.get(c.MONTH));
        System.out.println("日：" + c.get(c.DATE));
    }

    public static void showDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));
    }
}
