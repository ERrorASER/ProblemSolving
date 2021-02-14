package com.study.classAlgo;

import java.util.Scanner;

public class SWEA5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc = 1; tc<=t; tc++) {
			String input = sc.next();
			input = input.replace("()", "*");
			
			int original = 0;
			int result = 0;
			
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '*') {//������
					result += original;
				}else if(input.charAt(i) == '(') {//���ο� ����
					original ++;
					result ++;
				}else if(input.charAt(i) == ')') {//���볡
					original--;
				}
			}
			
			System.out.println("#"+tc+" "+result);
		}
		sc.close();
	}
}