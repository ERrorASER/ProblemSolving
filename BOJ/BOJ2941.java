package com.study.algo;

import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alphabet = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		
		String sentence = sc.next();
		int count = 0;
		
		while(sentence.length() > 0) {
			for(int i=0; i<8; i++) {//���ĺ��� �˻�
				int idx = sentence.indexOf(alphabet[i]);
				if( idx != -1) {//ã����
					count++;
					String original = sentence;
					sentence = sentence.substring(0,idx) +" " +original.substring(idx+ alphabet[i].length());
					break;
					//���� �κе�! ���� break�� ���ع����� c==dz=dddz==���� ����� ��� ����! �ڿ� �ִ� dz=�� �ƴ϶� z=�� �����ϰ� �޾Ƶ鿩��.
				}
			}
			
			if( !sentence.contains("c=") && !sentence.contains("c-") && !sentence.contains("dz=") && !sentence.contains("d-")&& !sentence.contains("lj")  && !sentence.contains("nj")&& !sentence.contains("s=")&& !sentence.contains("z=")) {
				//���� =�� -�� ���ĺ����� ���ٴ� ���� ����.
				sentence = sentence.replace(" ", ""); 
				count += sentence.length();
				sentence = "";
			}
		}
		System.out.println(count);
		sc.close();
	}
}
