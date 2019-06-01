package com.neuedu.inferfacedemo;
/**
 * 包装类
 * @author Administrator
 *
 */
public class WrapperDemo {
	public static void main(String[] args) {
		int parseInt = Integer.parseInt("45");
		System.out.println(parseInt);
		//int a = 5;
		//自动装箱
		//引用数据类型  基本数据类型 Integer a = new Integer(5);
		Integer a = 5;
		
		//自动拆箱
		//int b = new Integer(10).intValue();
		int b = new Integer(10);
		
		//定义成绩
		Integer score = null;
		
		Integer i1 = 127;
		Integer i2 = 127;
		System.err.println(i1 == i2);
		i1 = 128;
		i2 = 128;
		System.err.println(i1 == i2);	
		
	}
}
