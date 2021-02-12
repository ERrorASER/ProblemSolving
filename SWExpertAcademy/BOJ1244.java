package com.study.classAlgo;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt()+1;
		int[] switches = new int[n];
		
		for(int i=1; i<n; i++) {//0������ ���ٰ� �����ϱ�.
			switches[i] = sc.nextInt();
		}
		
		int sNum = sc.nextInt();//�л���
		
		
		for(int i=0; i<sNum; i++) {//�л� ������ ���� �� �ֱ�
			int s = sc.nextInt(); //����
			int number = sc.nextInt();//���� ��
			
			if(s == 1) {//���ڶ��, ���
				for(int j=number; j< n; j+=number) {
					switches[j] = switches[j] == 0? 1:0;
				}
			}else if(s==2) {//���ڶ��,���� ���� ��Ī�� ���¸� �ٲ��ش�.
				int left = number-1;
				int right = number+1;
				while(true) {
					if(left<1 || right>=n) break;
					if(switches[left]!=switches[right]) break;
					left--;
					right++;
				}
				left++;
				right--;
				for(int k=left; k<=right; k++) {
					switches[k] = switches[k] == 0? 1:0;
				}
				
			}
			
		}
		
		for(int i=1; i<n; i++) {
			System.out.print(switches[i]+" ");
			if(i%20 ==0) System.out.println();
		}	
	}
}
