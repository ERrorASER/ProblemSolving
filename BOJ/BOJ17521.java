package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17521 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		long w = Integer.parseInt(st.nextToken());
		long coin = 0;
		int[] chart = new int[n];
		
		for(int i=0; i<n; i++) {
			chart[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<n-1; i++) {
			if(chart[i] < chart[i+1]) {//´ÙÀ½³¯ ¿Ã¶ú¾î
				if(w>=chart[i]) {
					coin += w/chart[i];
					w %= chart[i];
				}
			}else if(chart[i]> chart[i+1]) {//¶³¾îÁü
				w += coin * chart[i];
				coin = 0;
			}
		}
		w += coin * chart[n-1];
		System.out.println(w);
		
	}

}
