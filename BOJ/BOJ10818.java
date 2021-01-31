package com.study.algo;

import java.util.Scanner;

public class BOJ10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int max = -1000001;
		int min = 1000001;
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			if(max<num)
				max = num;
			if(min>num)
				min = num;
		}
		System.out.println(min +" "+ max);
	}

}
