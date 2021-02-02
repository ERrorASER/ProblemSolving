package com.study.classAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] boxes = new int[100];
		for(int tc = 1; tc<=10; tc++) {
			int dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {//박스 넣기
				boxes[i] = sc.nextInt();
			}
			int result = 0;
			for(int i=0; i<dump; i++) {//dump 횟수만큼 진행
				Arrays.sort(boxes);//오름차순, 맨앞이 작은 수, 맨 뒤가 큰 수
				if(boxes[99]-boxes[0]>= 2) {
					boxes[99]--;
					boxes[0]++;
					
				}else if(boxes[99]-boxes[0] <=1){
					
					break;
				}
			}
			Arrays.sort(boxes);
			
			result = boxes[99]-boxes[0];
			System.out.println("#"+tc+" "+result);
		}
		sc.close();
	}

}
