package SocketServer.UploadFile.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    实现文件上传到服务器到案例(服务器端)
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
//        1. 创建本地字节输出流，写入文件到本地
        //先判断本地是否有FileLoad文件夹
        File directoryFile = new File("/Users/shangmengqi/Desktop/kylin/JAVA学习/day02-code/src/SocketServer/UploadFile/Server/FileLoad");
        if(!directoryFile.exists()){
            directoryFile.mkdir();
        }
        File file = new File(directoryFile,"Music.mp3");

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));

//        2. 创建ServerSocket对象，使用其getIntputStream()方法，获取网络输入流对象，读取该文件
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();

        int len = 0;

        byte[] bytes = new byte[1024];

        while ((len = is.read(bytes)) != -1) {
           bos.write(bytes,0,len);
        }

//        3. 使用其getOutputStream（）方法，获取网络输出流对象，向用户发送上传成功的提示。
        OutputStream os = socket.getOutputStream();
        os.write("上传文件成功！".getBytes());

//        4. 释放资源
        bos.close();
        socket.close();
        server.close();


    }
}
