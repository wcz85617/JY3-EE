package com.alibaba.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class serSocket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务端开启");
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream ));
            String s = bufferedReader.readLine();
            System.out.println("s");
            bufferedReader.close();
            inputStream.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
