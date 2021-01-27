package com.study.algo;

import java.util.Scanner;

public class BOJ2475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[5];
		int check = 0;
		
		for(int i=0; i<5; i++) {
			num[i] = sc.nextInt();
			check += Math.pow(num[i], 2);
		}
		
		check %= 10;
		System.out.println(check);
		
		sc.close();
	}

}