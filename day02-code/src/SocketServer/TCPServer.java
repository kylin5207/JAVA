package SocketServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
    ServerSocket实现服务器类的套接字
    public ServerSocket(int port) :使用该构造方法在创建ServerSocket对象时，就可以将其绑定到一个指定的端口号上，参数port就是端口号。

    public Socket accept():
        侦听并接受连接，返回一个新的Socket对象，用于和客户端实现通信。该方法会一直阻塞直到建立连接。
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);

        Socket socket = server.accept();

        InputStream is = socket.getInputStream();

        byte[] bytes = new byte[1024];

        int len = is.read(bytes);

        System.out.println(new String(bytes, 0, len));

        OutputStream os = socket.getOutputStream();

        os.write("服务器端收到".getBytes());

        socket.close();

        server.close();
    }
}
