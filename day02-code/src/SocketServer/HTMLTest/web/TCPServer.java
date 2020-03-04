package SocketServer.HTMLTest.web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1. 创建一个服务器ServerSocket
        ServerSocket server = new ServerSocket(8080);

        /*
            启动后，发现客户端无法显示页面到图片信息，这是因为：
            浏览器解析服务器诙谐的html页面，如果页面中有图片，那么服务器会单独的开启一个线程，读取服务器的图片

         */

        while(true){
            //2. 使用accept()获取到请求到客户端对象（浏览器）
            Socket socket = server.accept();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //3. 使用getInputStream（）获取网络字节输入流对象
                        InputStream is = socket.getInputStream();

                        //将网络字节输入流对象，转换为字符缓冲输入流
                        BufferedReader bis = new BufferedReader(new InputStreamReader(is));

                        //将客户端请求信息到第一行读取出来
                        String webinfo = bis.readLine();

                        System.out.println(webinfo);
                        //将读取到信息进行切割
                        String[] array = webinfo.split(" ");
                        String path = array[1];

                        System.out.println("path:" + path);
                        //创建本地字节输入流，构造方法中，绑定要读取到路径
                        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day02-code/src/SocketServer/HTMLTest" + path);

                        //使用getOutputStream()获取网络字节输出流
                        OutputStream os = socket.getOutputStream();

                        //写入HTTP协议响应头，固定写法：
                        os.write("HTTP/1.1 200 0K\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //必须要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while((len = fis.read(bytes)) != -1){
                            os.write(bytes,0,len);
                        }

                        fis.close();
                        socket.close();
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();

        }

        //server.close();
    }
}
