package com.study.algo;

import java.util.Scanner;

public class BOJ13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] rooms = new int[n];
		long count = 0;
		
		for(int i=0; i<n; i++) {
			rooms[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			count++;
			rooms[i] -= b;//������ �����忡 �� �������� ���� 1���� �־���Ѵ�. 
//			System.out.println("i : "+i+" count: "+count +" rooms:" +rooms[i]);
			if(rooms[i] > 0) {//������ �ƴϸ�, �ΰ������� �ʿ���.
				
				count += (rooms[i]/c);
//				System.out.println("������i : "+i+" count: "+count +" rooms:" +rooms[i]);
				if(rooms[i] %c > 0) {
					count++;
//					System.out.println("����i : "+i+" count: "+count +" rooms:" +rooms[i]);
					
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
