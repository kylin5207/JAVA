import org.junit.Test;
import sun.SolarTerms;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SolarTermsTest {
    @Test
    public void testGetSolatName() throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2020-01-04");
        System.out.println(SolarTerms.getSolatName(date));
//        System.out.println(SolarTerms.getSolatName(2020, "05-20"));
    }

    @Test
    public void test2() throws ParseException {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateStr = df.format(date);

        //将年份日期存储
        int currentYear = Integer.parseInt(currentDateStr.substring(0, 4));
        int nextYear = currentYear + 1;

        //计算当前年份的春分和下一个春分日
        String currentDay = SolarTerms.getSolarTermNum(currentYear, "CHUNFEN");
        String nextDay = SolarTerms.getSolarTermNum(nextYear, "CHUNFEN");

        Date currentCFDay = df.parse(String.valueOf(currentYear) + "-03-" +  currentDay);
        Date nextCFDay = df.parse(String.valueOf(nextYear) + "-03-" +  nextDay);

        System.out.println(currentCFDay);
        System.out.println(nextCFDay);
        long days = (nextCFDay.getTime() - currentCFDay.getTime()) / 1000 / 60 / 60 / 24;
        long passDays = (date.getTime() - currentCFDay.getTime()) / 1000 / 60 / 60 / 24;

        System.out.println(days);
        System.out.println(passDays);

        System.out.println(1.0 * 360 / days * passDays);

    }
}


