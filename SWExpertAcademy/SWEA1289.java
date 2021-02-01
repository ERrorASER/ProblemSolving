package com.study.classAlgo;

import java.util.Scanner;

public class SWEA1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int tc=1; tc<=t; tc++) {
			String original = sc.next();
			int[] token = new int[original.length()];
			for(int i = 0; i < original.length(); i++) {
				token[i] = original.charAt(i)-'0';
			}
			int count = token[0];
			
			for(int i = 1; i < token.length; i++) {
				if(token[i] != token[i-1])
					count++;
			}
			
			System.out.println("#"+tc+":"+count);
		}

	}

}
