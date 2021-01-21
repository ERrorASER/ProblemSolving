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
		
		int[] count = new int[26];//���ĺ� ī��Ʈ, ���⿡�� ���� ū �� �̾Ƴ��ž�.
		int max = -1;
		boolean isDuplicated = false; //�ߺ� üũ
		int index = 0; //���� ���� ���ĺ� �ε��� üũ
		
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
 			}else if(max == count[i] && count[i] != 0) {//break������ 334�϶��� üũ�ع���..
 				isDuplicated = true;
 				
 			}
 		}
 		System.out.println(isDuplicated? "?" : alphabet[index]);
 		sc.close();
	}
}