package com.neuedu.util;



import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.util.Random;

public class proUtil {

   public static Date getStringConverseDate(String date){
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       java.sql.Date date1 = null;
       try {
           java.util.Date parse = simpleDateFormat.parse(date);

           date1 = new java.sql.Date(parse.getTime());


       } catch (ParseException e) {
           e.printStackTrace();
       }
       return  date1;

   }

    public  static  String getProId()
   {
       Random random = new Random();
       int i = random.nextInt(100);
       String str = null;
       str = String.valueOf(System.currentTimeMillis());
       if(i<10){
           str = str+"0"+i;
       }

       return str += i;

   }


}
