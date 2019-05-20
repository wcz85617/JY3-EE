package com.alibaba.socket;

import java.io.*;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("hello ni hao");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
