package com.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class BOJ9461 {
	public static long[] numbers = new long[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		numbers[0] = 1;
		numbers[1] = 1;
		numbers[2] = 1;
		for(int i=3; i<101; i++) {
			if(numbers[i] ==0) numbers[i] = numbers[i-3]+numbers[i-2];
		}
		for(int t = 0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(numbers[n-1]);

		}
		
		
	}

}
