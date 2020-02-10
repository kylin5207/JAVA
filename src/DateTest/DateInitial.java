package DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateInitial {
    public static void main(String[] args) throws ParseException {
//        使用空参数构造方法，得到当前日期时间（CST中国时区）
        Date date = new Date();
        System.out.println("当前日期："+date);

//        使用DateFormat的format()方法按照指定格式，对date进行格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String datetext = sdf.format(date);
        System.out.println("格式化处理后的日期对象文本："+datetext);

//        使用DateFormat的parse()方法，将字符串解析为Date日期
        String text = "1996:02:14 12:22:33";
//        注意：parse方法可能会产生异常
        Date date1 = sdf.parse(text);
        System.out.println("解析字符串，得到Date："+date1);

    }
}
