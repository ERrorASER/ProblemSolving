package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {

	public static int n;
	public static int[] numbers;
	public static char[] operators, results;
	public static boolean[] isSelected;
	public static int MAX = Integer.MIN_VALUE;
	public static int MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numbers = new int[n];
		operators = new char[n-1];
		isSelected = new boolean[n-1];
		results = new char[n-1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int temp = Integer.parseInt(st.nextToken());
			for(int j=0; j<temp; j++) {
				if(i==0) operators[cnt] = '+';
				if(i==1) operators[cnt] = '-';
				if(i==2) operators[cnt] = '*';
				if(i==3) operators[cnt] = '/';
				cnt++;
			}
		}
		permutation(0);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	static public void permutation(int cnt) {
		if(cnt == n-1) {
			int sum = numbers[0];
			for(int i=0; i<n-1; i++) {
				if(results[i] == '+') sum += numbers[i+1]; 
				else if(results[i] == '-') sum -= numbers[i+1];
				else if(results[i] == '*') sum *= numbers[i+1]; 
				else if(results[i] == '/') sum /= numbers[i+1]; 
			}
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		
		for(int i=0; i<n-1; i++) {
			if(isSelected[i]) continue;
			results[cnt] = operators[i];
			isSelected[i] = true;
			permutation(cnt+1);
			
			isSelected[i] = false;
		}	
	}
}