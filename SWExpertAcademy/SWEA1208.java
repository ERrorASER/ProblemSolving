package com.study.classAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] boxes = new int[100];
		for(int tc = 1; tc<=10; tc++) {
			int dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {//�ڽ� �ֱ�
				boxes[i] = sc.nextInt();
			}
			int result = 0;
			for(int i=0; i<dump; i++) {//dump Ƚ����ŭ ����
				Arrays.sort(boxes);//��������, �Ǿ��� ���� ��, �� �ڰ� ū ��
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
