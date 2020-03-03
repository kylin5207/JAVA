package SocketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
    TCP通信的客户端：
        java.net.Socket:该类实现客户端套接字，套接字指的是两台设备之间通讯的端点
        构造方法：
             public Socket(String host, int port) :创建套接字对象并将其连接到指定主机上的指定端口号。如果指定的host是null ，则相当于指定地址为回送地址。

        使用方法：
            1. 创建一个客户端对象Socket，构造方法绑定方法服务器的IP地址和端口号
            2. 使用socket对象中的方法getOutputStream（）获取网络字节输出流对象
            3. 使用网络字节输出流OutputStream对象中的write，给服务器发送数据
            4. 使用Socket对象中的getInputStream（）获取网络自己输出流对象
            5. 使用InputStream中的read（）读取数据
            6. 关闭socket

        注意：
            1。客户端和服务器进行交互，必须使用Socket提供的网络流，不能使用自己创建的流对象
            2。与服务器经过3次握手建立连接，如果服务器没有启动，会抛出异常；否则，进行交互
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好服务器".getBytes());

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes, 0, len));

        socket.close();
    }
}
