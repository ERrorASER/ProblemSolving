package com.study.algo;

import java.util.Scanner;

public class BOJ5622 {
	// ���� -> ����
	// 1:1�� �ƴ϶� 1:3 || 1:4�ΰ� ����
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();

		char[] alphabet = {'n','A','B','C','D','E',
				'F','G','H','I','J',
				'K','L','M','N','O',
				'P','Q','R','S','T',
				'U','V','W','X','Y',
		'Z'};
		int temp = 0;
		int result = 0;

		for(int i=0; i<number.length(); i++) {
			for(int j=1; j<alphabet.length; j++) { //j�� alphabet index! 1���� ����
				if(number.charAt(i) == alphabet[j] && j < 16) { //1~6����
					if(j%3 == 1 || j%3 == 2)	result += (j/3)+2;
					else result += (j/3)+1;
					break;
				}else if(number.charAt(i) == alphabet[j] && j >= 15) {//7,8,9
					if(j>=20 && j<=22){//8��
						result +=8;
						break;
					}else if(j>22) {//9��
						result += 9;
						break;
					}else if(j<20) {//7��
						result += 7;
						break;
					}
				}
			}
		}
		result += 1*number.length();
		System.out.println(result);
		sc.close();
	}

}
