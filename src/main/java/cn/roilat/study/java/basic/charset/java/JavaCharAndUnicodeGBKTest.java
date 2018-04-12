package cn.roilat.study.java.basic.charset.java;

import java.io.UnsupportedEncodingException;

public class JavaCharAndUnicodeGBKTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "I am ��ɽ";
		/**1*/printHex(s.toCharArray());//����ı�����utf-16,ascii�ַ���λ��0ռ��: 0049 0020 0061 006D 0020 541B 5C71
		/**2*/printHex(s.getBytes("ISO-8859-1"));//����δ֪ʱʹ��003Fռλ�� 49 20 61 6D 20 3F 3F
		/**3*/printHex(s.getBytes("GBK"));//�������б��룺 49 20 61 6D 20 BE FD C9 BD
		/**4*/printHex(s.getBytes("UTF-8"));//49 20 61 6D 20 E5 90 9B E5 B1 B1
		/**
		 * UTF8->UniCode
		 * E5 90 9B=11100101 10010000 10011011=01010100 00011011=54 1B
		 * E5 B1 B1=11100101 10110001 10110001=01011100 01110001=5C 71
		 * ��1����һ��
		 */
	}

	public static void printHex(char[] data) {
		char[] temp = "0123456789ABCDEF".toCharArray();
		StringBuffer all = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < data.length; j++) {
			sb.setLength(0);
			int i = 0;
			while (i++ < 4) {
				sb.insert(0, temp[data[j] & 0x0000000f]);
				data[j] >>= 4;
			}
			all.append(sb.toString()).append(" ");
		}
		System.out.println(all.toString());
	}
	
	public static void printHex(byte[] data) {
		char[] temp = "0123456789ABCDEF".toCharArray();
		StringBuffer all = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < data.length; j++) {
			sb.setLength(0);
			int i = 0;
			while (i++ < 2) {
				sb.insert(0, temp[data[j] & 0x0000000f]);
				data[j] >>= 4;
			}
			all.append(sb.toString()).append(" ");
		}
		System.out.println(all.toString());
	}

}
