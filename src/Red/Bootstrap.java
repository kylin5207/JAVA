package Red;

/*
普通红包，平均分
手气红包，金额不超过普通红包的两倍
*/

public class Bootstrap {
    public static void main(String[] args) {
        RedPacketFrame frame = new Myred("来自Kylin的红包");

        //设置红包发送人
        frame.setOwnerName("帅琦");

        //普通红包
//        OpenMode normal = new NormalMode();
//        frame.setOpenWay(normal);

        //拼手气红包
        OpenMode random = new RandomMode();
        frame.setOpenWay(random);

    }
}
