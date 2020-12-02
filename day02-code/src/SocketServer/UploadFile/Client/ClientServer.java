package SocketServer.UploadFile.Client;

import java.io.*;
import java.net.Socket;

/*
    实现文件上传到服务器到案例(客户端)
        注意：
            1. 当客户端和服务器对本地硬盘进行读写时，需要使用本地的字节流对象（本地流）
               当客户端和服务器之间进行读写时，需要使用Socket提供的字节流对象（网络流）
            2. 步骤：
                1. 创建本地字节输入流，读取本地到文件
                2. 创建Socket对象，使用其getOutputStream()方法，获取网络输出流对象，写入该文件
                3. 使用其getInputStream（）方法，获取网络输入流对象，查看服务器返回到消息。
                4. 释放资源

 */
public class ClientServer {
    public static void main(String[] args) throws IOException {
//        1. 创建本地字节输入流，读取本地到文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/SocketServer/UploadFile/Client/Music.mp3"));

//        2. 创建Socket对象，使用其getOutputStream()方法，获取网络输出流对象，写入该文件
        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream ops = socket.getOutputStream();

        int len;
        byte[] bytes = new byte[1024];

        while ((len = bis.read(bytes)) != -1) {
            ops.write(bytes,0,len);
        }

        /*
            写一个文件结束标记，使用shutdownOutput（）禁用此输出流
                对于TCP套接字，任何以前写入的数据都将被发送，并且后面跟TCP的正常连接终止序列
         */
        socket.shutdownOutput();

//        3. 使用其getInputStream（）方法，获取网络输入流对象，查看服务器返回到消息。
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }

//        4. 释放资源
        bis.close();
        socket.close();


    }

}
