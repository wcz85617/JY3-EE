package com.neuedu.inferfacedemo;
/**
 * �ַ�������API
 * @author Administrator
 *
 */
public class StringDemo2 {
	
	public static void main(String[] args) {
		String str = "789456198001014561";
		System.out.println(str.length());
		String[] strs = {"1","2"};
		System.out.println(strs.length);
		//charAt(int index)
		char charAt = str.charAt(0);
		System.out.println(charAt);
		//substring();
		//���֤�� ��ȡ����������
		//789456198001014561
		String substring = str.substring(6,14);
		System.out.println(substring);
		//compareTo
		String str2 = "ABC";
		String str3 = "abc";
		int compareTo = str2.compareTo(str3);
		System.out.println(compareTo);
		
		//ƴ���ַ���
		String concat = str2.concat(str3);
		System.out.println(concat);
		//indexOf()
		String str4 = "neuedu";
		int indexOf = str4.indexOf("e",2);
		System.out.println(indexOf);
		//lastIndexOf()
		String str5 = "neuedue";
		int lastIndexOf = str5.lastIndexOf("e");
		System.out.println(lastIndexOf);
		
		//ת��дתСд
		String upperCase = str5.toUpperCase();
		System.out.println(upperCase);
		String lowerCase = upperCase.toLowerCase();
		System.out.println(lowerCase);
		
		//replace
		String str6 ="neusofto";
		String replace = str6.replace('o', 'l');
		System.out.println(replace);
		
		//trim ȥ���ո�
		String str7 = "   456   ";
		String trim = str7.trim();
		System.out.println(trim);
		
		//startsWith endsWith
		String str8 = "www.neuedu.com";
		boolean startsWith = str8.startsWith("www");
		System.out.println(startsWith);
		boolean endsWith = str8.endsWith("com");
		System.out.println(endsWith);
		
		//contains
		String str9 = "i love china";
		boolean contains = str9.contains("love");
		System.out.println(contains);
		
		//split �и�
		String str10 = "1,����,18,���,��D888";
		String[] split = str10.split(",");
		System.out.println(split[0]);
		
		//equals equalsIgnoreCase
		String str11 = "CSDN";
		String str12 = "csdn";
		System.out.println(str11.equalsIgnoreCase(str12));
		
		//gbk
		byte[] bs = new byte[] {95,96};
		String string = new String(bs);
		System.out.println(string);
		
		//����������ת��Ϊ�ַ���
		String valueOf =String.valueOf(1.5);
		System.out.println(valueOf);
	}
}
