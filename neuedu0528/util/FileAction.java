package com.neuedu.util;

import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

public class FileAction {

    public static String uploadFile(Part part) {

        String submittedFileName = part.getSubmittedFileName();
        InputStream inputStream = null;
        OutputStream os = null;
        UUID str = UUID.randomUUID();
        String name = str+submittedFileName;
        try {
            inputStream = part.getInputStream();
            os= new FileOutputStream("C:\\image\\"+name);
            int buffer = 0;
            byte[] bs = new byte[1024];
            while ((buffer=inputStream.read(bs))!=-1){

                os.write(bs,0,buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  name;
        //添加图片名字 避免重复的第一种方法
        //String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        //避免重复的第二种方法

    }

}
