package com.study.algo;

import java.util.Scanner;

public class SW2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int count;
		int temp = 0;
		for(int i=0; i<t; i++) {
			count = 0;
			for(int j=0; j<10; j++) {
				temp = sc.nextInt();
				if(temp %2 == 1)
					count += temp;
			}
			System.out.println("#"+(i+1)+" " +count);
		}
	}

}
