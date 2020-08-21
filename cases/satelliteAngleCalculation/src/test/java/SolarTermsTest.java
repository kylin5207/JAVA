import org.junit.Test;
import sun.SolarTerms;

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
    public void test2(){
        int i = 12;
        System.out.println(String.format("%02d", i));

    }
}
