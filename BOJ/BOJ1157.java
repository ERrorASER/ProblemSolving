package com.study.algo;

import java.util.Scanner;

public class BOJ1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toUpperCase();
		char[] alphabet = {'A','B','C','D','E',
				'F','G','H','I','J',
				'K','L','M','N','O',
				'P','Q','R','S','T',
				'U','V','W','X','Y',
				'Z'};
		
		int[] count = new int[26];//알파벳 카운트, 여기에서 가장 큰 수 뽑아낼거야.
		int max = -1;
		boolean isDuplicated = false; //중복 체크
		int index = 0; //가장 많은 알파벳 인덱스 체크
		
 		for(int i=0; i<str.length(); i++) {
			for(int j=0; j<alphabet.length; j++) {
				if(str.charAt(i) == alphabet[j]) {
					count[j]++;
					break;
				}
			}
		}

 		for(int i=0; i<alphabet.length; i++) {
 			if(max <count[i]) {
 				max = count[i];
 				index = i;
 				isDuplicated = false;
 			}else if(max == count[i] && count[i] != 0) {//break넣으면 334일때도 체크해버림..
 				isDuplicated = true;
 				
 			}
 		}
 		System.out.println(isDuplicated? "?" : alphabet[index]);
 		sc.close();
	}
}