package DateTest;
/*请使⽤日期时间相关的API，计算出⼀一个人已经出⽣了多少天。
    思路:
        1.获取当前时间对应的毫秒值
        2.获取⾃⼰出⽣日期对应的毫秒值
        3.两个时间相减(当前时间– 出⽣日期)*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CalculateBirthdays {
    public static void main(String[] args) throws ParseException {
//        1.  获取出生日期
        System.out.println("请输入出生日期：yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        String birth = sc.next();

//        2. 利用DateFormat的parse方法将字符串转为Date对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate = sdf.parse(birth);

//        3. 把Date格式的出生日期转换为毫秒值
        long birthTimeMillies = birthDate.getTime();

//        4. 获取当前日期，转换为毫秒值
        long currentTimeMillies = new Date().getTime();

//        5. 两者相减，之后将差值转换为天数
        long substract = currentTimeMillies - birthTimeMillies;
        int birthdays = (int) (substract / 1000 / 60 / 60 / 24);
        System.out.println("你已经出生" + birthdays + "天！");

    }


}
