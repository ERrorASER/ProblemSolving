package com.study.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA4408_자기_방으로_돌아가기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());		
		
		for(int t = 1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int count = 0;
			int[] corridor = new int[201];
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken())+1)/2;
				int y = (Integer.parseInt(st.nextToken())+1)/2;
				
				if(x<y) {
					for(int j=x; j<=y; j++) {
						corridor[j]++;
					}
				}else {
					for(int j=y; j<=x; j++) {
						corridor[j]++;
					}
				}
			}
			Arrays.sort(corridor);
			count = corridor[200];
			sb.append("#"+t+" "+count+"\n");
		}
		
		System.out.println(sb);
	}

}
