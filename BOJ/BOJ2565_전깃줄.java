package com.study.classAlgo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ2565_전깃줄 {

	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] wire = new int[n][2];
		int[] LIS = new int[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(wire, new Comparator<int[]>() {
		    @Override
		    public int compare(int[] o1, int[] o2) {
		    	return o1[0] - o2[0];
		    }
		});
		int max = 0;
		for(int i=0; i<n; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				if(wire[j][1]<wire[i][1]) {
					LIS[i] = Math.max(LIS[i], LIS[j]+1);
				}
			}
			max = Math.max(max, LIS[i]);
		}
		System.out.println(n-max);
	}

}
