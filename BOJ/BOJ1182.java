package com.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
	static int[] numbers;
	static long sum,s,n,count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		numbers = new int[(int) n];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		count = 0;
		subset(0,0);
		System.out.println(count);
	}
	
	public static void subset(int start, long sum) {
		if(start == n)
			return;
		if(sum+numbers[start] == s) {
			count++;
			
		}
		
		//선택했을 때
		subset(start+1, sum+numbers[start]);
		
		//선택하지 않았을 때
		subset(start+1, sum);
	}

}
