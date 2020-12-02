package SocketServer;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 本来想测试下python是如何进行udp数据传输的，为了便于查看，利用java创建一个使用udp协议的服务器
 *
 */

public class UDPServer {
    public static void main(String[] args) throws IOException {
//        1. 创建服务器端
        DatagramSocket socket = new DatagramSocket(8888);

//        2. 创建数据报，用于接受客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);

//        3. 接收客户端发送的数据
        System.out.println("服务器：服务器已经启动～");
        socket.receive(packet); //接收数据前会一直阻塞

//      4. 查看用户数据
        String info = new String(data, 0, packet.getLength());
        System.out.println("新的用户消息：" + info);

//        5. 响应客户端
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] data2 = ("我们收到了您的请求：" + info).getBytes();

//        6. 创建数据包
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);

//        7. 响应客户度啊
        socket.send(packet2);

        System.out.println("本次服务结束，等待客户发送新消息");

        socket.close();
    }
}
