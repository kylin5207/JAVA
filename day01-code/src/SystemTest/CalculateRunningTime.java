package SystemTest;

//验证for循环打印数字1-9999所需要使⽤的时间(毫秒)
public class CalculateRunningTime {
    public static void main(String[] args) {
//        记录开始时间
        long start = System.currentTimeMillis();

        for (int i = 1; i <= 9999; i++) {
            System.out.println(i);
        }

//        记录结束时间
        long end = System.currentTimeMillis();

        System.out.println("运行时间为：" + (end - start) + "毫秒");
    }
}
