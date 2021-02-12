package com.study.classAlgo;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt()+1;
		int[] switches = new int[n];
		
		for(int i=1; i<n; i++) {//0번쨰는 없다고 생각하기.
			switches[i] = sc.nextInt();
		}
		
		int sNum = sc.nextInt();//학생수
		
		
		for(int i=0; i<sNum; i++) {//학생 성별과 받은 수 넣기
			int s = sc.nextInt(); //성별
			int number = sc.nextInt();//받은 수
			
			if(s == 1) {//남자라면, 배수
				for(int j=number; j< n; j+=number) {
					switches[j] = switches[j] == 0? 1:0;
				}
			}else if(s==2) {//여자라면,받은 수의 대칭들 상태를 바꿔준다.
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
