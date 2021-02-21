package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2961 {

	public static long[] s,b;
	public static int n;
	public static long min = 1000000000;
	public static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new long[n];
		b = new long[n];
		StringTokenizer st ;
		isSelected = new boolean[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Long.parseLong(st.nextToken());
			b[i] = Long.parseLong(st.nextToken());
		}
		subset(0,1,0);
		System.out.println(min);
	}
	
	//신맛은 곱
	//쓴맛은 합
	
	public static void subset(int i, long sSum, long bSum) {
		if(i==n) {
			int selectedCnt = 0;
			for(int j=0; j<n; j++) {
				if(isSelected[j]) {
					selectedCnt++;
				}
			}
			
			if(selectedCnt>0) {
				min = Math.min(min, Math.abs(sSum-bSum));
			}
			return;
		}
		
		//재료를 골랐을 경우
		isSelected[i] = true;
		subset(i+1, sSum*s[i],bSum+b[i]);
		
		//재료를 고르지 않았을 경우
		isSelected[i] = false;
		subset(i+1,sSum,bSum);
	}
}