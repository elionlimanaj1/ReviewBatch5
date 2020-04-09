package com.review1.Collection;

public class StringStringBuilderStringBuffer {

	public static void main(String[] args) {
		String str1 = "abc";

		str1.toUpperCase();
		System.out.println(str1);

		String str2 = "abc";

		System.out.println("str1 == str2 " + (str1 == str2));

		String str3 = new String("abc");
		System.out.println("str1 == str3 " + (str1 == str3));

		System.out.println("str1.equals(str3) " + str1.equals(str3));
		
		
		
		System.out.println("\n---StringBuilder---");
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("abc");
		strBuilder.append("def");
		System.out.println("strBuilder " + strBuilder);

		System.out.println("\n---StringBuffer---");
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("abc");
		strBuffer.append("def");
		System.out.println("strBuffer " + strBuffer);
	}
}
