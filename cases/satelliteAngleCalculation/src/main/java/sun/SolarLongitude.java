package sun;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolarLongitude {
    public static void main(String[] args) throws ParseException {
        //1. 获取当前日期
        Date todaydate = new Date();

        //2. 日期格式化
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        todaydate = df.parse(df.format(todaydate));
        todaydate = df.parse("2000-04-03");
        Date startDate = df.parse("2000-03-20");

        //gettime()获取的时间是目标Date对象对应的毫秒值
        long days = (todaydate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24 % 365;
        int solarTerms = (int)(todaydate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24 % 365;
        System.out.println(days);
//        Date startDate = df.parse("2000-03-24");
//        System.out.println(startDate);
//
//        Double days = (todaydate.getTime() - startDate.getTime()) / 60 / 24
//        System.out.println( - startDate);
    }
}
