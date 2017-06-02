package org.hgp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 应用多线程实现服务器与多客户端之间的通信
 */
public class Server2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);


        Socket socket = null;
        int count = 0;//记录客户端的数量
        while (true) {
            socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
            count++;
            System.out.println("客户端连接的数量：" + count);
        }


    }

    static class ServerThread extends Thread {

        Socket socket;

        public ServerThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream is = null;
            try {
                is = socket.getInputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String info = null;

            try {
                while ((info = br.readLine()) != null) {
                    System.out.println("接收到：" + info);
                }
                br.close();
                isr.close();
                is.close();
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
