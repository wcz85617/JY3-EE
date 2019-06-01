package com.neuedu.inferfacedemo;
/**
 * 字符串
 * @author Administrator
 *
 */
public class StringDemo {
	
	public static void main(String[] args) {
//		String str = "hello";
//		String string = "hello";
//		String string2 = new String("hello");
//		System.out.println(str==string);
		
//		char[] c = {'中','国','人'};
//		String string3 = new String(c,1,1);
//		System.out.println(string3);
		
//		byte[] bs = {1,2,3,4,5};
//		String string4 = new String(bs);
//		System.out.println(string4);
		
		//equals          ==比较的是地址
		String str = "hello";
		String str2 = new String("hello");
		System.out.println(str.equals(str2));
	}
}
