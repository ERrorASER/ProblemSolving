package com.study.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = numbers[0];
		for(int i=1; i<n; i++) {
			numbers[i] = Math.max(numbers[i], numbers[i-1]+numbers[i]);
			max = Math.max(numbers[i], max);
		}
		System.out.println(max);
	}

}
